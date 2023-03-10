package edu.clevertec.task.controller;

import edu.clevertec.task.service.ReceiptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Работа с view, передача информации на фронт
 */
@Controller
@AllArgsConstructor
@RequestMapping("/check")
public class ReceiptController {

    private final ReceiptService receiptService;

    /**
     * Получает входную строку и прокидывает полученную модель на фронт
     *
     * @param model  модель для передачи атрибута в html
     * @param source входная строка с товарами и дисконтной картой
     * @return путь к html
     */
    @GetMapping("/{source}")
    public String createReceipt(Model model, @PathVariable String source) {
        model.addAttribute("receipt", receiptService.createReceipt(source));
        return "receipt";
    }

}
