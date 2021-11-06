package kr.kmisoib.kmisoib_kr.cipher.alphabet;

import kr.kmisoib.kmisoib_kr.exception.SymbolException;

public class Alphabet {

    private static int spaceNum = 32;

    public static int getCode(char ch) throws SymbolException {
        int code;
        if(ch >= 'а' && ch <= 'я') code = ch % 1072 + 224;
        else if(ch >= 'А' && ch <= 'Я') code = ch % 1040 + 192;
        else if (ch == ' ') code = spaceNum;
        else throw new SymbolException("Неверный символ " + ch);
        return code;
    }

    public static char getChar(int number) throws Exception {
        if(number >= 192 && number <= 223) return (char)(number % 32 + 1040);
        else if(number >= 224 && number <= 255) return (char)(number % 32 + 1072);
        else if(number == 32) return ' ';
        else throw new SymbolException("Символа с кодом " + number + " не существует");
    }
}
