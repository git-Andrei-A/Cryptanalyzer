package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;
import cryptoanalizer.utils.Output;
import cryptoanalizer.utils.Utils;
import cryptoanalizer.utils.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static cryptoanalizer.constants.Constants.ALPHABET;
import static cryptoanalizer.constants.Constants.TXT_FOLDER;

/*
1. Load reference text (2-nd part of "War and Peace") and calculate reference Frequency of words HashMap <String, int>.
2. In cycle make decryption of encrypted file by all keys of ALPHABET (from 1 to alphabet length - 1):
-  split into words by space (taking the assumption space is the most frequent symbol);
- calculate  current frequency of words;
- compare reference frequency  and current frequency, save the best decryption;
3. Write  decryption.
*/

public class BruteForce implements Action {

    @Override
    public Result execute (String[] parameters) {

        System.out.println("parameters: " + Arrays.toString(parameters) + "\nTXT_FOLDER: " + TXT_FOLDER);

        Input rf = new Input();
        ArrayList<String> list =  rf.readFile(parameters[0]);

        Utils ut = new Utils();
        HashMap<String, Integer> referenceFrequency = ut.wordsFrequency(list);

        ArrayList<String> encryptedList =  rf.readFile(parameters[1]);

        double maxIntersection = Double.MIN_VALUE;
        int successKey = 0;
        ArrayList<String> successDecodedList = new ArrayList<>();
        for (int i = 1; i < ALPHABET.length() - 1; i++ ){
            int key = -i;
            ArrayList<String> decodedList = ut.codeCaesar(encryptedList, key);

            HashMap<String, Integer> encodedFrequency = ut.wordsFrequency(decodedList);
            double intersection = ut.calculateSimilarity(referenceFrequency, encodedFrequency);

            if (maxIntersection < intersection){
                maxIntersection = intersection;
                successKey = key;
                successDecodedList.clear();
                successDecodedList.addAll(decodedList);
            }


        }

        Output o = new Output();
        o.writeFile(successDecodedList, parameters[2]);

        System.out.println("FINAL maxintersection: " + maxIntersection);

        return new Result("BruteForece complite", ResultCode.OK);
    }
}
