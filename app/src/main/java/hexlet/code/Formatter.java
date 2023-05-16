package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String useForm(String format, Map<String, Object> mapFile1, Map<String, Object> mapFile2,
                                 Map<String, Object> jointMap) {
        return switch (format) {
            case "stylish" -> Stylish.construct(mapFile1, mapFile2, jointMap);
            case "plain" -> Plain.construct(mapFile1, mapFile2, jointMap);
            default -> "Format is not exist";
        };
    }
}
