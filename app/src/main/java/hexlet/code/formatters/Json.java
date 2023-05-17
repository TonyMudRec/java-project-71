package hexlet.code.formatters;

import java.util.Map;

public class Json {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String,
            Object> jointMap) {
        StringBuilder sb = new StringBuilder();
        String currentValue;
        String lastValue;
        sb.append("{" + "\n");
        for (String key : jointMap.keySet()) {
            currentValue = jointMap.get(key) == null ? "null" : jointMap.get(key).toString();
            lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
            if (!mapFile1.containsKey(key) || (mapFile2.containsKey(key) && !lastValue.equals(currentValue))) {
                sb.append("    \"").append(key).append(":").append(currentValue).append("\",\n");
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
