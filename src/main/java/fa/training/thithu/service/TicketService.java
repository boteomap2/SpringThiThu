package fa.training.thithu.service;

import fa.training.thithu.entity.DangKyVe;
import fa.training.thithu.entity.LoTrinh;
import java.util.List;

public interface TicketService {
    void save(DangKyVe dangKyVe);
    DangKyVe getTicketById(String id);
    List<DangKyVe> getList();
    List<DangKyVe> getListNgayKHBeforeCurrentDate();
    void deleteById(String id);
}
