package cryptoanalizer.controllers;

import cryptoanalizer.commands.Action;
import cryptoanalizer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        // actionName == ecode
        //  parameters  = {encode text.txt encode.txt 12}
        Action action = Actions.find(actionName);
        Result result = action.execute(parameters);
        return result;
    }

}
