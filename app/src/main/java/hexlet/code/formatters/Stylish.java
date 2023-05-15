package hexlet.code.formatters;

import java.util.Map;

public class Stylish {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String, Object> jointMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("{" + "\n");
        for (String key : jointMap.keySet()) {
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (mapFile1.get(key) == null && mapFile2.get(key) != null) {
                    sb.append(" - ").append(key).append(": ").append("null").append("\n");
                    sb.append(" + ").append(key).append(": ").append(mapFile2.get(key).toString()).append("\n");
                } else if (mapFile1.get(key) != null && mapFile2.get(key) == null) {
                    sb.append(" - ").append(key).append(": ").append(mapFile1.get(key).toString()).append("\n");
                    sb.append(" + ").append(key).append(": ").append("null").append("\n");
                } else if (!mapFile1.get(key).equals(mapFile2.get(key))) {
                    sb.append(" - ").append(key).append(": ").append(mapFile1.get(key).toString()).append("\n");
                    sb.append(" + ").append(key).append(": ").append(mapFile2.get(key).toString()).append("\n");
                } else {
                    sb.append("   ").append(key).append(": ").append(jointMap.get(key).toString()).append("\n");
                }
            } else if (!mapFile1.containsKey(key)) {
                sb.append(" + ").append(key).append(": ").append(jointMap.get(key).toString()).append("\n");
            } else {
                sb.append(" - ").append(key).append(": ").append(jointMap.get(key).toString()).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
