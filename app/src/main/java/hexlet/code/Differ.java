package hexlet.code;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Differ {

    public static String generate(String filepath1, String filepath2) throws IOException {
        Map<String, Object> mapFile1 = new HashMap<>(Parser.parse(filepath1));
        Map<String, Object> mapFile2 = new HashMap<>(Parser.parse(filepath2));
        Map<String, Object> jointMap = new TreeMap<>(mapFile1);
        jointMap.putAll(mapFile2);
        StringBuilder sb = new StringBuilder("{" + "\n");
        for (String key : jointMap.keySet()) {
            if ((mapFile1.containsKey(key) && mapFile2.containsKey(key))
                    && mapFile1.get(key).equals(mapFile2.get(key))) {
                sb.append("   ").append(key).append(": ").append(jointMap.get(key)).append("\n");
            } else if ((mapFile1.containsKey(key) && mapFile2.containsKey(key))
                    && !mapFile1.get(key).equals(mapFile2.get(key))) {
                sb.append(" - ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
                sb.append(" + ").append(key).append(": ").append(mapFile2.get(key)).append("\n");
            } else if (!mapFile1.containsKey(key)) {
                sb.append(" + ").append(key).append(": ").append(jointMap.get(key)).append("\n");
            } else {
                sb.append(" - ").append(key).append(": ").append(jointMap.get(key)).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
