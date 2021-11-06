package kr.kmisoib.kmisoib_kr.controller;

import kr.kmisoib.kmisoib_kr.cipher.des.DES;
import kr.kmisoib.kmisoib_kr.dto.BasicEncryptionForm;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/des")
public class DESController {

    @GetMapping
    public String getDESPage(Model model) {
        model.addAttribute("encryptionForm", new BasicEncryptionForm());
        return "des";
    }

    @PostMapping
    public String getCode(BasicEncryptionForm form, Model model) throws SymbolException {
        DES des = new DES(form.getText(), form.getKey());
        model.addAttribute("encrypted", des.encrypt());
        model.addAttribute("des", des);
        return "des_result";
    }
}
