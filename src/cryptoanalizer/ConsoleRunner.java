package cryptoanalizer;

import cryptoanalizer.entity.Result;

public class ConsoleRunner {
    public static void main(String[] args) {

        Application application = new Application();

        Result result = application.run(args); // command argument1 argument2 argument3

        System.out.println(result);
    }
}