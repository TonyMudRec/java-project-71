package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Json {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String,
            Object> jointMap) {
        Map<String, String> result = new TreeMap<>();
        ObjectMapper om = new ObjectMapper();
        String currentValue;
        String lastValue;

        for (String key : jointMap.keySet()) {
            currentValue = jointMap.get(key) == null ? "null" : jointMap.get(key).toString();
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
                if (!lastValue.equals(currentValue)) {
                    result.put("- " + key, lastValue);
                    result.put("+ " + key, currentValue);
                } else {
                    result.put("  " + key, currentValue);
                }
            } else if (!mapFile1.containsKey(key)) {
                result.put("+ " + key, currentValue);
            } else {
                lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
                result.put("- " + key, lastValue);
            }
        }
        try {
            om.writeValue(new File("Diff.json"), result);
        } catch (IOException e) {
            return "Something wrong. File cannot be created";
        }
        return "File 'Diff.json' was successfully created!";
    }
}
