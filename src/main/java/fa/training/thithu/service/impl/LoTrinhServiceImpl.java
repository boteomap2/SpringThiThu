package fa.training.thithu.service.impl;

import fa.training.thithu.entity.LoTrinh;
import fa.training.thithu.repository.LoTrinhRepository;
import fa.training.thithu.service.LoTrinhService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoTrinhServiceImpl implements LoTrinhService {
    private final LoTrinhRepository loTrinhRepository;

    @Autowired
    public LoTrinhServiceImpl(LoTrinhRepository loTrinhRepository) {
        this.loTrinhRepository = loTrinhRepository;
    }

    @Override
    @Transactional
    public LoTrinh getLoTrinhById(String id) {
        return loTrinhRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<LoTrinh> getList() {
        return loTrinhRepository.findAll();
    }

    @Override
    @Transactional
    public boolean existsById(String id) {
        return loTrinhRepository.existsById(id);
    }
}
