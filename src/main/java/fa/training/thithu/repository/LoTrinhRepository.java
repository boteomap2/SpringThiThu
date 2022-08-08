package fa.training.thithu.repository;

import fa.training.thithu.entity.LoTrinh;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoTrinhRepository extends JpaRepository<LoTrinh, String> {

}
