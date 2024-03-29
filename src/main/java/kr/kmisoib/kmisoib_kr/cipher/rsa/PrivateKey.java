package kr.kmisoib.kmisoib_kr.cipher.rsa;

import java.math.BigInteger;

public class PrivateKey {

    private BigInteger d;
    private BigInteger n;

    public PrivateKey(BigInteger d, BigInteger n) {
        this.d = d;
        this.n = n;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getN() {
        return n;
    }
}
