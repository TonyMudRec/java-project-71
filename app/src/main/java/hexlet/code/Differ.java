package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Differ {

    public static Path convertPathToAbsolutePath(String filepath) {
        Path absoluteFilePath = Paths.get(filepath).toAbsolutePath().normalize();
        if (Files.notExists(absoluteFilePath)) {
            System.out.println("File '" + filepath + "' does not exist");
            return null;
        }
        return  absoluteFilePath;
    }
    public static String generate(String filepath1, String filepath2) throws IOException {
        String path1 = String.valueOf(convertPathToAbsolutePath(filepath1));
        String path2 = String.valueOf(convertPathToAbsolutePath(filepath2));
        ObjectMapper om = new ObjectMapper();
        StringBuilder sb = new StringBuilder("{" + "\n");
        String contentFile1 = new String(Files.readAllBytes(Paths.get(path1)));
        String contentFile2 = new String(Files.readAllBytes(Paths.get(path2)));
        Map<String, Object> mapFile1 = om.readValue(contentFile1, HashMap.class);
        Map<String, Object> mapFile2 = om.readValue(contentFile2, HashMap.class);
        Map<String, Object> jointMap = new TreeMap<>(mapFile1);
        jointMap.putAll(mapFile2);

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
