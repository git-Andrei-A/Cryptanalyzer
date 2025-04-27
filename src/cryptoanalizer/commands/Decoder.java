package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;
import cryptoanalizer.utils.Utils;
import cryptoanalizer.utils.Input;
import cryptoanalizer.utils.Output;

import java.util.ArrayList;

public class Decoder implements Action {

    @Override
    public Result execute (String[] parameters) {

        Input rf = new Input();
        ArrayList<String> list =  rf.readFile(parameters[0]);

        Utils dc = new Utils();
        int key = - Integer.parseInt(parameters[2]);
        ArrayList<String> encodedList = dc.codeCaesar(list, key);


        Output o = new Output();
        o.writeFile(encodedList, parameters[1]);

        return new Result("File successfully decoded. Created ../texts/decrypted.txt.", ResultCode.OK);
    }
}
