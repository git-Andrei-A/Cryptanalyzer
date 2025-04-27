package cryptoanalizer.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


import static cryptoanalizer.constants.Constants.ALPHABET;

public class Utils {
    public ArrayList<String> codeCaesar(ArrayList <String> textForCipher, int key) {
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

    public HashMap <String, Integer> wordsFrequency (ArrayList <String> list) {
        HashMap <String, Integer> frequency = new HashMap<>();
        for (String string : list) {
            string = string.trim();
            string = string.replace(" ", "  ");
            String[] words = string.split(" ");
            for (String word : words) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        return frequency;
    }

    public double calculateSimilarity(HashMap<String, Integer> masterMap, HashMap<String, Integer> testMap) {
        Set<String> masterKeys = masterMap.keySet(); // Возвращает множество ключей коллекции
        Set<String> testKeys = testMap.keySet();

        Set<String> intersection = new HashSet<>(masterKeys);
        intersection.retainAll(testKeys); // Оставляет только элементы, которые есть и в текущем множестве masterKeys, и в testKeys

        Set<String> union = new HashSet<>(masterKeys);
        union.addAll(testKeys); // Добавляет все элементы в  union (а там уже masterKeys)  из  коллекции testKeys

        if (union.isEmpty()) return 0.0; // защита от деления на 0

        if (intersection.isEmpty()) return 1.0; //идея подсказала, вроде хорошо  выглядит

        return (double) intersection.size() / union.size(); // и чем больше это число тем больше сходство
    }
    
}
