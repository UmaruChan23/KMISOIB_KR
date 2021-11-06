package kr.kmisoib.kmisoib_kr.cipher.service;

import kr.kmisoib.kmisoib_kr.cipher.alphabet.Alphabet;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;

import java.util.ArrayList;
import java.util.List;

public class CipherService {

    public String xor(String right, String key) {
        ArrayList<Boolean> r = toBooleanArray(right);
        ArrayList<Boolean> k = toBooleanArray(key);
        ArrayList<Boolean> result = new ArrayList<>();
        for(int i = 0; i < r.size(); i++){
            result.add(r.get(i) ^ k.get(i));
        }
        return toBinaryString(result);
    }

    public ArrayList<String> stringToBlocks(String text, int blockSize) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            if(i > 0 && i % blockSize == 0){
                result.append(" ").append(text.charAt(i));
            } else {
                result.append(text.charAt(i));
            }
        }
        return new ArrayList<>(List.of(result.toString().split(" ")));
    }

    public String toBinaryString(ArrayList<Boolean> booleans) {
        StringBuilder result = new StringBuilder();
        for(boolean b: booleans) {
            if(b) {
                result.append("1");
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }

    public ArrayList<Boolean> toBooleanArray(String text) {
        ArrayList<Boolean> result = new ArrayList<>();
        for(char ch: text.toCharArray()) {
            if(ch == '1') {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public String stringToBinary(String text) throws SymbolException {
        StringBuilder result = new StringBuilder();
        for(char ch: text.toCharArray()) {
            result.append(Integer.toBinaryString(Alphabet.getCode(ch)));
        }
        return result.toString();
    }
}
