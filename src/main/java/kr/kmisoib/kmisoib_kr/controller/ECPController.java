package kr.kmisoib.kmisoib_kr.controller;

import kr.kmisoib.kmisoib_kr.cipher.ecp.ECP;
import kr.kmisoib.kmisoib_kr.dto.PQHForm;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecp")
public class ECPController {

    @GetMapping
    public String getECPPage(Model model) {
        model.addAttribute("pqForm", new PQHForm());
        return "ecp";
    }

    @PostMapping
    public String getEcp(PQHForm form, Model model) throws SymbolException {
        ECP ecp = new ECP(form.getP(), form.getQ(), form.getH0());
        model.addAttribute("ecp", ecp.getECP(form.getText()).toString());
        model.addAttribute("rsa", ecp.getRsa());
        model.addAttribute("hash", ecp.getHash().getHash(form.getText()));
        return "ecp_result";
    }
}
