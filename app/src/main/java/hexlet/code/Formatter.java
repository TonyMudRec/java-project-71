package hexlet.code;

import hexlet.code.formatters.Format;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String useForm(String format, Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Map<String, Format> forms = Map.of(
                "stylish", new Stylish(),
                "plain" , new Plain(),
                "json", new Json()
        );
        return forms.get(format).construct(mapFile1, mapFile2);
    }
}
