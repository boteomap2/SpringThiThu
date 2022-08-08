package fa.training.thithu.controller;

import fa.training.thithu.entity.DangKyVe;
import fa.training.thithu.entity.LoTrinh;
import fa.training.thithu.service.LoTrinhService;
import fa.training.thithu.service.TicketService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final LoTrinhService loTrinhService;

    @Autowired
    public TicketController(TicketService ticketService, LoTrinhService loTrinhService) {
        this.ticketService = ticketService;
        this.loTrinhService = loTrinhService;
    }

    @GetMapping("/register")
    public String showRegisterTicketForm(Model model) {
        model.addAttribute("loTrinhs", loTrinhService.getList());
        model.addAttribute("ticket", new DangKyVe());
        return "ticket/register";
    }

    @PostMapping("/register")
    public String registerTicket(@Valid @ModelAttribute("ticket") DangKyVe dangKyVe,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        if (!loTrinhService.existsById(dangKyVe.getLoTrinh().getMaLT())) {
            model.addAttribute("loTrinhs", loTrinhService.getList());
            bindingResult.rejectValue("loTrinh.maLT", "error.maLT", "Khong ton tai thong tin lo trinh trong he thong");
        }
        if (bindingResult.hasErrors()) {
            return "ticket/register";
        }
        ticketService.save(dangKyVe);
        return "redirect:/ticket/list";
    }

    @GetMapping("/list")
    public String showTicket(Model model) {
        model.addAttribute("tickets", ticketService.getListNgayKHBeforeCurrentDate());
        return "/ticket/list";
    }

    @GetMapping("/update")
    public String showUpdateTicketForm(@RequestParam(name = "id") String id, Model model) {
        model.addAttribute("loTrinhs", loTrinhService.getList());
        model.addAttribute("ticket", ticketService.getTicketById(id));
        return "ticket/update";
    }

    @PostMapping("/update")
    public String updateTicket(@Valid @ModelAttribute("ticket") DangKyVe dangKyVe, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (loTrinhService.existsById(dangKyVe.getLoTrinh().getMaLT())) {
            bindingResult.rejectValue("loTrinh.maLT", "error.maLT", "Khong ton tai thong tin lo trinh trong he thong");
        }
        if (bindingResult.hasErrors()) {
            return "ticket/update";
        }
        ticketService.save(dangKyVe);
        return "redirect:/ticket/list";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public int calculate(@RequestParam("soLuongVe") String soLuongVeString,
                         @RequestParam("maLT") String maLT) {
        int soLuongVe = Integer.parseInt(soLuongVeString);
        LoTrinh loTrinh = loTrinhService.getLoTrinhById(maLT);
        if (loTrinh == null) return 0;
        int tongTien = soLuongVe * loTrinh.getGiaVe();
        if (soLuongVe >= 4) {
            tongTien -= tongTien * 10 / 100;
        }
        return tongTien;
    }
}
