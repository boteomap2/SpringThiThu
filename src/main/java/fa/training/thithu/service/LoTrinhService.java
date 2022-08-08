package fa.training.thithu.service;

import fa.training.thithu.entity.LoTrinh;
import java.util.List;

public interface LoTrinhService {
    LoTrinh getLoTrinhById(String id);
    List<LoTrinh> getList();
    boolean existsById(String id);
}
