package kr.kmisoib.kmisoib_kr.dto;

import java.math.BigInteger;

public class RSAForm {

    private BigInteger p;
    private BigInteger q;
    private String text;

    public RSAForm() {
    }

    public RSAForm(BigInteger p, BigInteger q, String text) {
        this.p = p;
        this.q = q;
        this.text = text;
    }

    public BigInteger getP() {
        return p;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public BigInteger getQ() {
        return q;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
