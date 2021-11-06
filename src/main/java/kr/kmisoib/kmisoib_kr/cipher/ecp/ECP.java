package kr.kmisoib.kmisoib_kr.cipher.ecp;

import kr.kmisoib.kmisoib_kr.cipher.hash.Hash;
import kr.kmisoib.kmisoib_kr.cipher.rsa.RSA;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;

import java.math.BigInteger;

public class ECP {

    private Hash hash;
    private RSA rsa;

    public ECP(BigInteger p, BigInteger q, BigInteger h0) {
        hash = new Hash(p, q, h0);
        rsa = new RSA(p, q);
    }

    public BigInteger getECP(String text) throws SymbolException {
        return hash.getHash(text).modPow(rsa.getD(), rsa.getN());
    }

    public Hash getHash() {
        return hash;
    }

    public RSA getRsa() {
        return rsa;
    }
}
