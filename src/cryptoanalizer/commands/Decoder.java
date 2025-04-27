package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;
import cryptoanalizer.utils.Utils;
import cryptoanalizer.utils.Input;
import cryptoanalizer.utils.Output;

import java.util.ArrayList;
import java.util.Arrays;

import static cryptoanalizer.constants.Constants.TXT_FOLDER;

public class Decoder implements Action {

    @Override
    public Result execute (String[] parameters) {
        // TODO Decoder read decode write

        System.out.println("parameters: " + Arrays.toString(parameters) + "TXT_FOLDER: " + TXT_FOLDER);

        Input rf = new Input();
        ArrayList<String> list =  rf.readFile(parameters[0]);

        /*for (int i = 0; i < list.size(); i++) { // source file for decode
            System.out.println(list.get(i));
        }*/

        Utils dc = new Utils();
        int key = - Integer.parseInt(parameters[2]);
        ArrayList<String> encodedList = dc.codeCaesar(list, key);


        Output o = new Output();
        o.writeFile(encodedList, parameters[1]);

        return new Result("decode all right", ResultCode.OK);
    }
}
