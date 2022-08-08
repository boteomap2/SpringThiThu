package fa.training.thithu.repository;

import fa.training.thithu.entity.DangKyVe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<DangKyVe, String> {
    @Query("select dkv from DangKyVe dkv where dkv.ngayKH > current_date()")
    List<DangKyVe> getListNgayKHBeforeCurrentDate();
}
