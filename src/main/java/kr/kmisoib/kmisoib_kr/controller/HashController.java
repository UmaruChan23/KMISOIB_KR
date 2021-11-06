package kr.kmisoib.kmisoib_kr.controller;

import kr.kmisoib.kmisoib_kr.cipher.hash.Hash;
import kr.kmisoib.kmisoib_kr.dto.BasicEncryptionForm;
import kr.kmisoib.kmisoib_kr.dto.PQHForm;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;

@Controller
@RequestMapping("/hash")
public class HashController {

    @GetMapping
    public String getHashPage(Model model) {
        model.addAttribute("pqForm", new PQHForm());
        return "hash";
    }

    @PostMapping
    public String getHash(PQHForm form, Model model) throws SymbolException {
        BigInteger p = form.getP();
        BigInteger q = form.getQ();
        BigInteger h0 = form.getH0();
        Hash hash = new Hash(p, q, h0);
        model.addAttribute("hash", hash);
        model.addAttribute("result", hash.getHash(form.getText()));
        return "hash_result";
    }
}
