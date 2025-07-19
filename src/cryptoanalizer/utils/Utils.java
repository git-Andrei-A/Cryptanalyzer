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
        Set<String> masterKeys = masterMap.keySet(); // Returns a set of keys of a collection
        Set<String> testKeys = testMap.keySet();

        Set<String> intersection = new HashSet<>(masterKeys);
        intersection.retainAll(testKeys); // Keeps only elements that are in both the current masterKeys set and testKeys

        Set<String> union = new HashSet<>(masterKeys);
        union.addAll(testKeys); // Adds all elements to the union (and there are already masterKeys) from the testKeys collection

        if (union.isEmpty()) return 0.0; // Divide by 0 protection

        if (intersection.isEmpty()) return 1.0; // complete match

        return (double) intersection.size() / union.size(); // the higher this number, the greater the similarity.
    }
    
}
