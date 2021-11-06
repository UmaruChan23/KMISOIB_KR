package kr.kmisoib.kmisoib_kr.cipher.rsa;

import kr.kmisoib.kmisoib_kr.cipher.alphabet.NewAphabet;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RSA {

    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger n;
    private final BigInteger phi;
    private final BigInteger d;
    private final BigInteger e;
    private final PublicKey publicKey;
    private final PrivateKey privateKey;

    public RSA(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = generateExponent();
        d = e.modInverse(phi);
        publicKey = new PublicKey(e, n);
        privateKey = new PrivateKey(d, n);
    }

    private BigInteger generateExponent() {
        while (true) {
            Random random = new Random();
            BigInteger exponent = new BigInteger(8, random);
            if (exponent.compareTo(BigInteger.ONE) != 0 && exponent.compareTo(phi) < 0 && exponent.gcd(phi)
                    .compareTo(BigInteger.ONE) == 0
            ) return exponent;
        }
    }

    public List<BigInteger> encrypt(String message) throws SymbolException {
        NewAphabet aphabet = new NewAphabet();
        List<BigInteger> result = new ArrayList<>();
        for(char ch : message.toCharArray()) {
            BigInteger code = new BigInteger(String.valueOf(aphabet.getCharCode(ch)));
            result.add(code.modPow(e, n));
        }
        return result;
    }

    public List<BigInteger> decrypt(List<BigInteger> cipher) throws SymbolException {
        List<BigInteger> result = new ArrayList<>();
        for(BigInteger ch : cipher) {
            result.add(ch.modPow(d, n));
        }
        return result;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getPhi() {
        return phi;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getE() {
        return e;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
