package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String,
            Object> jointMap) {
        String currentValue;
        String lastValue;
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String key : jointMap.keySet()) {
            currentValue = jointMap.get(key) == null ? "null" : jointMap.get(key).toString();
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
                if (!lastValue.equals(currentValue)) {
                    sb.append("\"- ").append(key).append("\":\"").append(lastValue).append("\",");
                    sb.append("\"+ ").append(key).append("\":\"").append(currentValue).append("\",");
                } else {
                    sb.append("\"").append(key).append("\":\"").append(currentValue).append("\",");
                }
            } else if (!mapFile1.containsKey(key)) {
                sb.append("\"+ ").append(key).append("\":\"").append(currentValue).append("\",");
            } else {
                lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
                sb.append("\"- ").append(key).append("\":\"").append(lastValue).append("\",");
            }
        }
        sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
}
