package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Differ {

    public static String generate(String filepath1, String filepath2, String format) {
        Map<String, Object> mapFile1 = new HashMap<>(Parser.parse(filepath1));
        Map<String, Object> mapFile2 = new HashMap<>(Parser.parse(filepath2));
        if (mapFile1.isEmpty() && mapFile2.isEmpty()) {
            return "";
        }
        Map<String, Object> jointMap = new TreeMap<>(mapFile1);
        jointMap.putAll(mapFile2);
        StringBuilder sb = new StringBuilder();
        if (format.equals("stylish")) {
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
        }
        return sb.toString();
    }
}
