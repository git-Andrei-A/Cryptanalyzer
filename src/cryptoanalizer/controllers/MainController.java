package cryptoanalizer.controllers;

import cryptoanalizer.commands.Action;
import cryptoanalizer.entity.Result;

public class MainController {

    public Result doAction(String actionName, String[] parameters) {
        Action action = Actions.find(actionName); // command
        return action.execute(parameters);
    }

}
