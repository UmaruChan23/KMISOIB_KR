package kr.kmisoib.kmisoib_kr.controller;

import kr.kmisoib.kmisoib_kr.cipher.gost.Gost;
import kr.kmisoib.kmisoib_kr.dto.BasicEncryptionForm;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gost")
public class GOSTController {

    @GetMapping
    public String getGOSTPage(Model model) {
        model.addAttribute("encryptionForm", new BasicEncryptionForm());
        return "gost";
    }

    @PostMapping
    public String getCode(BasicEncryptionForm form, Model model) throws SymbolException {
        Gost gost = new Gost(form.getText(), form.getKey());
        model.addAttribute("encrypted", gost.encrypt());
        return "gost_result";
    }

}
