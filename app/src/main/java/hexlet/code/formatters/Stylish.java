package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String,
            Object> jointMap) {
        StringBuilder sb = new StringBuilder();
        String currentValue;
        String lastValue;
        sb.append("{" + "\n");
        for (String key : jointMap.keySet()) {
            currentValue = jointMap.get(key) == null ? "null" : jointMap.get(key).toString();
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
                if (!lastValue.equals(currentValue)) {
                    sb.append(" - ").append(key).append(": ").append(lastValue).append("\n");
                    sb.append(" + ").append(key).append(": ").append(currentValue).append("\n");
                } else {
                    sb.append("   ").append(key).append(": ").append(currentValue).append("\n");
                }
            } else if (!mapFile1.containsKey(key)) {
                sb.append(" + ").append(key).append(": ").append(currentValue).append("\n");
            } else {
                lastValue = mapFile1.get(key) == null ? "null" : mapFile1.get(key).toString();
                sb.append(" - ").append(key).append(": ").append(lastValue).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}