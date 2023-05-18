package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String useForm(String format, Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        StringBuilder sb = new StringBuilder();
        Stylish stylish = new Stylish();
        Plain plain = new Plain();
        Json json = new Json();
        return switch (format) {
            case "stylish" -> sb.append("{\n").append(stylish.construct(mapFile1, mapFile2)).append("}").toString();
            case "plain" -> sb.append(plain.construct(mapFile1, mapFile2), 0
                    , plain.construct(mapFile1, mapFile2).length() - 1).toString();
            case "json" -> sb.append("{").append(json.construct(mapFile1, mapFile2), 0,
                    json.construct(mapFile1, mapFile2).length() - 1).append("}").toString();
            default -> "Format is not exist";
        };
    }
}
