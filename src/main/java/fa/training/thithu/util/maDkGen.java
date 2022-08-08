package fa.training.thithu.util;

import java.io.Serializable;
import java.util.stream.Stream;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class maDkGen implements IdentifierGenerator {

    private final String prefix = "DK";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
        throws HibernateException {
        String query = "SELECT dkv.maDK FROM DangKyVe dkv";
        Stream<String> ids = session.createQuery(query, String.class).stream();
        long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return prefix + (String.format("%03d", max + 1));
    }
}
