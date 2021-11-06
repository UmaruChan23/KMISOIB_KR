package kr.kmisoib.kmisoib_kr.controller;

import kr.kmisoib.kmisoib_kr.cipher.rsa.RSA;
import kr.kmisoib.kmisoib_kr.dto.RSAForm;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rsa")
public class RSAController {

    @GetMapping
    public String getRSAPage(Model model) {
        model.addAttribute("rsaForm", new RSAForm());
        return "rsa";
    }

    @PostMapping
    public String getCode(RSAForm form, Model model) throws SymbolException {
        RSA rsa = new RSA(form.getP(), form.getQ());
        model.addAttribute("result", rsa.encrypt(form.getText()));
        model.addAttribute("rsa", rsa);
        return "rsa_result";
    }

}
