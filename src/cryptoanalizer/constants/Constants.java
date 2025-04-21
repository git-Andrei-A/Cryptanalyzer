package cryptoanalizer.constants;

import java.io.File;

public class Constants {
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String cypher = "0123456789";
    private static final String marks = "~!@#$%^&*()_-+,.:№;?*";

    public static final String  ALPHABET = rus + rus.toLowerCase() + cypher + marks;
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "texts" + File.separator;
}
