package hexlet.code.formatters;

import java.util.Map;

public class Json {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String,
            Object> jointMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + "\n");
        for (String key : jointMap.keySet()) {
            String currentValue = transformToString(jointMap.get(key));
            String lastValue = transformToString(mapFile1.get(key));
            if (!mapFile1.containsKey(key) || (mapFile2.containsKey(key) && !lastValue.equals(currentValue))) {
                sb.append("    \"").append(key).append("\": ").append(currentValue).append(",\n");
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("\n}");
        return sb.toString();
    }

    public static String transformToString(Object o) {
        String result;
        if (o == null) {
            result = "null";
        } else if (o instanceof String) {
            result = "\"" + o + "\"";
        } else {
            result = o.toString();
        }
        return result;
    }
}
