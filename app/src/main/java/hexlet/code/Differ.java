package hexlet.code;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) {
        Map<String, Object> mapFile1 = parser(filepath1);
        if (mapFile1.isEmpty()) {
            return "File '" + filepath1 + "' does not exist, or cannot be reading";
        }
        Map<String, Object> mapFile2 = parser(filepath2);
        if (mapFile1.isEmpty()) {
            return "File '" + filepath2 + "' does not exist, or cannot be reading";
        }
        return Formatter.useForm(format, mapFile1, mapFile2);
    }

    public static String generate(String filepath1, String filepath2) {
        return generate(filepath1, filepath2, "stylish");
    }

    public static Map<String, Object> parser(String filepath) {
        Map<String, Object> mapFile;
        try {
            mapFile = Parser.parse(filepath);
        } catch (NullPointerException | IOException e) {
            return new HashMap<>();
        }
        return mapFile;
    }
}
