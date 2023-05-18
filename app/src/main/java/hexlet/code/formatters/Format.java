package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public abstract class Format {
    public final String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Map<String, Object> unionMap = getUnionMap(mapFile1, mapFile2);
        StringBuilder sb = new StringBuilder();
        for (String key : unionMap.keySet()) {
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                if (!isEqual(mapFile1.get(key), mapFile2.get(key))) {
                    sb.append(buildString("changed", key, mapFile1.get(key), mapFile2.get(key)));
                } else {
                    sb.append(buildString("unchanged", key, mapFile1.get(key), mapFile2.get(key)));
                }
            } else if (!mapFile1.containsKey(key)) {
                sb.append(buildString("added", key, mapFile1.get(key), mapFile2.get(key)));
            } else {
                sb.append(buildString("removed", key, mapFile1.get(key), mapFile2.get(key)));
            }
        }
        return packer(sb.toString());
    }

    final Map<String, Object> getUnionMap(Map<String, Object> mapFile1, Map<String, Object> mapFile2) {
        Map<String, Object> unionMap = new TreeMap<>(mapFile1);
        unionMap.putAll(mapFile2);
        return unionMap;
    }

    abstract String packer(String string);

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
