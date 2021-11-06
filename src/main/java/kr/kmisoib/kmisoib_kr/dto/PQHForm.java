package kr.kmisoib.kmisoib_kr.dto;

import java.math.BigInteger;

public class PQHForm {

    private BigInteger p;
    private BigInteger q;
    private BigInteger h0;
    private String text;

    public PQHForm() {
    }

    public PQHForm(BigInteger p, BigInteger q, BigInteger h0, String text) {
        this.p = p;
        this.q = q;
        this.h0 = h0;
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

    public BigInteger getH0() {
        return h0;
    }

    public void setH0(BigInteger h0) {
        this.h0 = h0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
