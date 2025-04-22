package cryptoanalizer.utils;

import java.util.ArrayList;

import static cryptoanalizer.constants.Constants.ALPHABET;

public class Coders {
    public ArrayList <String> encodeCaesar (ArrayList <String> textForCipher, int key) {
        ArrayList<String> result = new ArrayList<>();
        for (String line : textForCipher) {
            //String line = textForCipher.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                //System.out.println("Исходный символ: " + ch);
                sb.append(CircularString (ALPHABET, ch, key));
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static char CircularString (String s, char ch, int key) { // index - start index,  key - step to right or if minus left
        int length = s.length();
        int index = s.indexOf(ch);

        index = ((index + key) % length + length) % length;

        //System.out.println("Закодированный символ: " +  s.charAt(index));
        return s.charAt(index);
    }
    
}
