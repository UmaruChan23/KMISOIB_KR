package kr.kmisoib.kmisoib_kr.cipher.hash;

import kr.kmisoib.kmisoib_kr.cipher.alphabet.NewAphabet;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;

import java.math.BigInteger;

public class Hash {
    private BigInteger p;
    private BigInteger q;
    private BigInteger H0;

    public Hash(BigInteger p, BigInteger q, BigInteger h0) {
        this.p = p;
        this.q = q;
        H0 = h0;
    }

    private BigInteger hashFunction(BigInteger x) {
        return  x.modPow(BigInteger.valueOf(2), p.multiply(q));
    }

    public BigInteger getHash(String text) throws SymbolException {
        NewAphabet alphabet = new NewAphabet();
        BigInteger hash = H0;
        for (char ch : text.toCharArray()) {
            int code = alphabet.getCharCode(ch);
            hash = hashFunction(hash.add(BigInteger.valueOf(code)));
        }
        return hash;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getH0() {
        return H0;
    }
}
