package cryptoanalizer.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static cryptoanalizer.constants.Constants.TXT_FOLDER;

public class Output {
    public boolean writeFile(ArrayList<String> arrWrite, String fileName) {

        Path filePath = Path.of(TXT_FOLDER + fileName);

        try (BufferedWriter rd = Files.newBufferedWriter(filePath)) {
            for (String str : arrWrite) {
                rd.write(str);
                rd.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
