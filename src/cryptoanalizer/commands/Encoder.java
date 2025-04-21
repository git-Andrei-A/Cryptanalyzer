package cryptoanalizer.commands;

import cryptoanalizer.entity.Result;
import cryptoanalizer.entity.ResultCode;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {
        // TODO Encoder something do
        return new Result("encode all right", ResultCode.OK);
    }
}
