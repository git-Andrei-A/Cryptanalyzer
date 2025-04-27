package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;
import cryptoanalizer.utils.Input;
import cryptoanalizer.utils.Output;
import cryptoanalizer.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;

import static cryptoanalizer.constants.Constants.TXT_FOLDER;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        System.out.println("parameters: " + Arrays.toString(parameters) + "TXT_FOLDER: " + TXT_FOLDER);

        Input rf = new Input();
        ArrayList<String> list =  rf.readFile(parameters[0]);

        /*for (int i = 0; i < list.size(); i++) { // source file
            System.out.println(list.get(i));
        }*/

        Utils ec = new Utils();
        ArrayList<String> encodedList = ec.codeCaesar(list, Integer.parseInt(parameters[2]));

        /*for (int i = 0; i < encodedList.size(); i++) { // source file
            System.out.println(encodedList.get(i));
        }*/

        Output o = new Output();
        o.writeFile(encodedList, parameters[1]);

        return new Result("encode all right", ResultCode.OK);
    }
}
