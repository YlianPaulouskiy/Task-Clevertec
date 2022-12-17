package edu.clevertec.task.controller;


import edu.clevertec.task.service.ReceiptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/check")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;

    }

    @GetMapping("/{source}")
    public String createReceipt(Model model, @PathVariable String source) {
        model.addAttribute("receipt", receiptService.createReceipt(source));

        return "receipt";
    }

}
