package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;
import cryptoanalizer.utils.ReadFile;
import cryptoanalizer.utils.Encoders;

import java.util.ArrayList;
import java.util.Arrays;

import static cryptoanalizer.constants.Constants.TXT_FOLDER;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        // TODO Encoder something do

        // encode
        //write
        System.out.println("parameters: " + Arrays.toString(parameters));
        System.out.println(TXT_FOLDER);
        ReadFile rf = new ReadFile();
        ArrayList<String> list =  rf.readFile(parameters[0]);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Encoders ec = new Encoders();

        ArrayList<String> encodedList = ec.encodeCaesar(list, Integer.parseInt(parameters[2]));

        return new Result("encode all right", ResultCode.OK);


    }
}
