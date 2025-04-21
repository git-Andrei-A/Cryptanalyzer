package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;

public class BrudeForce implements Action {

    @Override
    public Result execute (String[] parameters) {
        // TODO BrudeForece something do
        return new Result("BrudeForece complite", ResultCode.OK);
    }
}
