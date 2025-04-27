package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;
import cryptoanalizer.utils.Input;
import cryptoanalizer.utils.Output;
import cryptoanalizer.utils.Utils;

import java.util.ArrayList;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        Input rf = new Input();
        ArrayList<String> list =  rf.readFile(parameters[0]);

        Utils ec = new Utils();
        ArrayList<String> encodedList = ec.codeCaesar(list, Integer.parseInt(parameters[2]));

        Output o = new Output();
        o.writeFile(encodedList, parameters[1]);

        return new Result("File ../texts/encoded.txt successfully created", ResultCode.OK);
    }
}
