package cryptoanalizer.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static cryptoanalizer.constants.Constants.*;


public class ReadFile {
    public ArrayList<String> readFile (String file){
        ArrayList<String> lines = new ArrayList<>();

        Path filePath = Path.of(TXT_FOLDER + file);

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)){
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return lines;

    }
}
