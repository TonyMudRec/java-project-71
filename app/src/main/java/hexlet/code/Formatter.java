package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {

    public static String useForm(String format, Map<String, Object> mapFile1, Map<String, Object> mapFile2,
                                 Map<String, Object> jointMap) {
        String result;
        switch (format) {
            case "plain" -> result = Plain.construct(mapFile1, mapFile2, jointMap);
            default -> result = Stylish.construct(mapFile1, mapFile2, jointMap);
        }
        return result;
    }
}
