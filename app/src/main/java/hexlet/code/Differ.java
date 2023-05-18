package hexlet.code;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Differ {

    public static String generate(String filepath1, String filepath2, String format) {
        Map<String, Object> mapFile1 = new HashMap<>();
        Map<String, Object> mapFile2;
        try {
            mapFile1 = Parser.parse(filepath1);
            mapFile2 = Parser.parse(filepath2);
        } catch (NullPointerException | IOException e) {
            String filepath = mapFile1.isEmpty() ? filepath1 : filepath2;
            return "File '" + filepath + "' does not exist, or cannot be reading";
        }
        return Formatter.useForm(format, mapFile1, mapFile2);
    }

    public static String generate(String filepath1, String filepath2) {
        Map<String, Object> mapFile1 = new HashMap<>();
        Map<String, Object> mapFile2;
        try {
            mapFile1 = Parser.parse(filepath1);
            mapFile2 = Parser.parse(filepath2);
        } catch (NullPointerException | IOException e) {
            String filepath = mapFile1.isEmpty() ? filepath1 : filepath2;
            return "File '" + filepath + "' does not exist, or cannot be reading";
        }
        return Formatter.useForm("stylish", mapFile1, mapFile2);
    }
}
