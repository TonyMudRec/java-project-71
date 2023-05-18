package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String useForm(String format, Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Stylish stylish = new Stylish();
        Plain plain = new Plain();
        Json json = new Json();
        return switch (format) {
            case "stylish" -> stylish.construct(mapFile1, mapFile2);
            case "plain" -> plain.construct(mapFile1, mapFile2);
            case "json" -> json.construct(mapFile1, mapFile2);
            default -> "Format is not exist";
        };
    }
}
