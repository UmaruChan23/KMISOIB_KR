package kr.kmisoib.kmisoib_kr.cipher.gost;

import kr.kmisoib.kmisoib_kr.cipher.service.CipherService;
import kr.kmisoib.kmisoib_kr.exception.SymbolException;

import java.util.ArrayList;
import java.util.Collections;

public class Gost {

    private final int[][] substitute = {
            {1, 13, 4, 6, 7, 5, 14, 4},
            {15, 11, 11, 12, 13, 8, 11, 10},
            {13, 4, 10, 7, 10, 1, 4, 9},
            {0, 1, 0, 1, 1, 13, 12, 2},
            {5, 3, 7, 5, 0, 10, 6, 13},
            {7, 15, 2, 15, 8, 3, 13 ,8},
            {10, 5, 1, 13, 9, 4, 15, 0},
            {4, 9, 13, 8, 15, 2, 10, 14},
            {9, 0, 3, 4, 14, 14, 2, 6},
            {2, 10, 6, 10, 4, 15, 3, 11},
            {3, 14, 8, 9, 6, 12, 8, 1},
            {14, 7, 5, 14, 12, 7, 1, 12},
            {6, 6, 9, 0, 11, 6, 0, 7},
            {11, 8, 12, 3, 2, 0, 7, 15},
            {8, 2, 15, 11, 5, 9, 5, 5},
            {12, 12, 14, 2, 3, 11, 9, 3}
    };

    private final CipherService service = new CipherService();

    /** текст */
    private final String text;

    /** Ключ */
    private final String key;

    public Gost(String text, String key) {
        this.text = text;
        this.key = key;
    }

    public String encrypt() throws SymbolException {
        String binaryMessage = service.stringToBinary(text);
        // Левая часть сообщения
        String left = binaryMessage.substring(0, binaryMessage.length() / 2);
        // Правая часть сообщения
        String right = binaryMessage.substring(binaryMessage.length() / 2);
        // Ключ
        String binaryKey = service.stringToBinary(key);
        String afterF = f(right, binaryKey);
        String sub = substitute(afterF);
        String afterShift = shift(sub);
        String substituteLF = service.xor(left, afterShift);
        return right + substituteLF;
    }

    private String shift(String text) {
        return text.substring(11) + text.substring(0, 11);
    }

    private String substitute(String text) {
        ArrayList<String> blocks = service.stringToBlocks(text, 4);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < blocks.size(); i++) {
            int row = Integer.parseInt(blocks.get(i), 2);
            int column = i;
            String nextNumber = Integer.toBinaryString(substitute[row][column]);
            if(nextNumber.length() < 2) nextNumber = "000" + nextNumber;
            if(nextNumber.length() < 3) nextNumber = "00" + nextNumber;
            if(nextNumber.length() < 4) nextNumber = "0" + nextNumber;
            result.append(nextNumber);
        }
        return result.toString();
    }

    private String f(String right, String key) {
        ArrayList<Boolean> r = service.toBooleanArray(right);
        ArrayList<Boolean> k = service.toBooleanArray(key);
        ArrayList<Boolean> result = new ArrayList<>();
        boolean one = false;
        for(int i = r.size() - 1; i >= 0; i--){
            if(r.get(i) && k.get(i)) {
                result.add((r.get(i) ^ k.get(i)) | one);
                one = true;
            }else if(!r.get(i) && !k.get(i)) {
                result.add((r.get(i) ^ k.get(i)) | one);
                one = false;
            } else {
                if(one) {
                    result.add(false);
                    one = true;
                } else {
                    result.add(true);
                }
            }
        }
        Collections.reverse(result);
        return service.toBinaryString(result);
    }

}
