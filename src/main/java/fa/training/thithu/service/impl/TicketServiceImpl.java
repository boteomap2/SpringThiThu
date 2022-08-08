package fa.training.thithu.service.impl;

import fa.training.thithu.entity.DangKyVe;
import fa.training.thithu.repository.TicketRepository;
import fa.training.thithu.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional
    public void save(DangKyVe dangKyVe) {
        ticketRepository.save(dangKyVe);
    }

    @Override
    @Transactional
    public DangKyVe getTicketById(String id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<DangKyVe> getList() {
        return ticketRepository.findAll();
    }

    @Override
    @Transactional
    public List<DangKyVe> getListNgayKHBeforeCurrentDate() {
        return ticketRepository.getListNgayKHBeforeCurrentDate();
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        ticketRepository.deleteById(id);
    }
}
