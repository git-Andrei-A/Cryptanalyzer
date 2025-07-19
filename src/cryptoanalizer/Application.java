package cryptoanalizer;

import cryptoanalizer.controllers.MainController;
import cryptoanalizer.entity.Result;
import cryptoanalizer.exceptions.AppException;

import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application() {
        mainController = new MainController();

    }

    public Result run(String[] args) {

        if (args.length > 0) { // command argument1 argument2 argument3
            String action = args[0]; // command

            String[] parameters = Arrays.copyOfRange(args, 1, args.length); // parameters text.txt encode.txt 12

            return mainController.doAction(action, parameters);

        } else {
            throw new AppException("no args");
        }
    }
}
