package kr.kmisoib.kmisoib_kr.cipher.alphabet;

import kr.kmisoib.kmisoib_kr.exception.SymbolException;

public class NewAphabet {
    private final char[] alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();

    public int getCharCode(char ch) throws SymbolException {
        for(int i = 0; i < alphabet.length; i++) {
            if (ch == alphabet[i]) {
                return i + 1;
            }
        }
        throw new SymbolException("Неизвестный символ " + ch);
    }

    public char getCharFromCode(int code) throws SymbolException {
        for(int i = 0; i < alphabet.length; i++) {
            if (code == i + 1) {
                return alphabet[i];
            }
        }
        throw new SymbolException("Неизвестный код " + code);
    }
}
