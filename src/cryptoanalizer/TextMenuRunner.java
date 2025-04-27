package cryptoanalizer;

import cryptoanalizer.entity.Result;

import java.util.Scanner;

public class TextMenuRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Application application = new Application();
        while (true) {
            System.out.println("Choose command:");
            System.out.println("1. Encode");
            System.out.println("2. Decode");
            System.out.println("3. BrutForce");
            System.out.println("4. Exit");
            System.out.print("Enter number of your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter file name to encode (in folder /texts): ");
                    String encodeFile = scanner.nextLine().trim();

                    System.out.print("Enter length of key to encode: ");
                    String encodeKeyLength = scanner.nextLine().trim();

                    String[] encodeArgs = {"encode", encodeFile, "encoded.txt", encodeKeyLength};
                    Result encodeResult = application.run(encodeArgs);
                    System.out.println(encodeResult);
                    break;
                case "2":
                    System.out.print("Enter encoded file name (in folder /texts): ");
                    String encodedFile = scanner.nextLine().trim();

                    System.out.print("Enter length of key to decode: ");
                    String decodeKeyLength = scanner.nextLine().trim();

                    String[] decodeArgs = {"decode", encodedFile, "decrypted.txt", decodeKeyLength};
                    Result decodeResult = application.run(decodeArgs);
                    System.out.println(decodeResult);
                    break;
                case "3":
                    System.out.print("Enter file name for example (reference file in folder /texts):");
                    String referenceFile = scanner.nextLine().trim();

                    System.out.print("Enter encoded file name: ");
                    String brutForceFile = scanner.nextLine().trim();

                    String[] brutForceArgs = {"bruteforce", referenceFile, brutForceFile, "brutForceDecrypted.txt"};
                    Result brutForceResult = application.run(brutForceArgs);
                    System.out.println(brutForceResult);
                    break;

                case "4":
                    System.out.println("Exit...");
                    return;
            }
        }
    }
}
