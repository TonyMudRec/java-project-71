package hexlet.code.formatters;

import java.util.Map;

public class Plain {
    public static String construct(Map<String, Object> mapFile1, Map<String, Object> mapFile2, Map<String,
            Object> jointMap) {
        StringBuilder sb = new StringBuilder();
        String currentValue;
        String lastValue;
        for (String key : jointMap.keySet()) {
            currentValue = transformToString(jointMap.get(key));
            if (mapFile1.containsKey(key) && mapFile2.containsKey(key)) {
                lastValue = transformToString(mapFile1.get(key));
                if (!isEqual(mapFile1.get(key), mapFile2.get(key))) {
                    sb.append("Property '").append(key).append("' was updated. From ")
                            .append(lastValue).append(" to ")
                            .append(currentValue).append("\n");
                }
            } else if (!mapFile1.containsKey(key)) {
                sb.append("Property '").append(key).append("' was added with value: ")
                        .append(currentValue).append("\n");
            } else {
                sb.append("Property '").append(key).append("' was removed").append("\n");
            }
        }
        return sb.toString();
    }

    public static String transformToString(Object o) {
        String result;
        if (o == null) {
            result = "null";
        } else if (o instanceof String) {
            result = "'" + o + "'";
        } else if (o instanceof Integer
                || o instanceof Boolean
                || o instanceof Character) {
            result = o.toString();
        } else {
            result = "[complex value]";
        }
        return result;
    }

    public static boolean isEqual(Object o1, Object o2) {
        if (o1 == null | o2 == null) {
            return false;
        } else return (o1 == o2 || o1.equals(o2));
    }
}
