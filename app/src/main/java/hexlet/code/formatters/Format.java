package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public abstract class Format {
    public String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Map<String, Object> joinedMap = new TreeMap<>(mapFile1);
        joinedMap.putAll(mapFile2);
        StringBuilder sb = new StringBuilder();
        String status;
        for (String key : joinedMap.keySet()) {
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (!isEqual(mapFile1.get(key), mapFile2.get(key))) {
                    status = "changed";
                    sb.append(buildString(status, key, mapFile1.get(key), mapFile2.get(key)));
                } else {
                    status = "unchanged";
                    sb.append(buildString(status, key, mapFile1.get(key), mapFile2.get(key)));
                }
            } else if (!mapFile1.containsKey(key)) {
                status = "added";
                sb.append(buildString(status, key, mapFile1.get(key), mapFile2.get(key)));
            } else {
                status = "removed";
                sb.append(buildString(status, key, mapFile1.get(key), mapFile2.get(key)));
            }
        }
        return sb.toString();
    }

    abstract String buildString(String status, String key, Object lastValue, Object value);

    abstract String transformToString(Object o);

    static boolean isEqual(Object o1, Object o2) {
        if (o1 == null | o2 == null) {
            return false;
        } else {
            return (o1 == o2 || o1.equals(o2));
        }
    }
}
