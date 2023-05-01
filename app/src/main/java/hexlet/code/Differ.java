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
    final static Path ABSOLUTE_FILE_PATH_1 = Paths.get(App.getFilepath1()).toAbsolutePath().normalize();
    final static Path ABSOLUTE_FILE_PATH_2 = Paths.get(App.getFilepath2()).toAbsolutePath().normalize();

    public static String generate() throws IOException {
        if (Files.notExists(ABSOLUTE_FILE_PATH_1) || Files.notExists(ABSOLUTE_FILE_PATH_2)) {
            if (Files.notExists(ABSOLUTE_FILE_PATH_1)) {
                System.out.println("File '" + App.getFilepath1() + "' does not exist");
            }
            if (Files.notExists(ABSOLUTE_FILE_PATH_2)) {
                System.out.println("File '" + App.getFilepath2() + "' does not exist");
            }
            return null;
        }
        ObjectMapper om = new ObjectMapper();
        StringBuilder sb = new StringBuilder("{" + "\n");
        String contentFile1 = new String(Files.readAllBytes(Paths.get(ABSOLUTE_FILE_PATH_1.toUri())));
        String contentFile2 = new String(Files.readAllBytes(Paths.get(ABSOLUTE_FILE_PATH_2.toUri())));
        Map<String, Object> mapFile1 = om.readValue(contentFile1, HashMap.class);
        Map<String, Object> mapFile2 = om.readValue(contentFile2, HashMap.class);
        Map<String, Object> jointMap = new TreeMap<>(mapFile1);
        jointMap.putAll(mapFile2);

        for (String key : jointMap.keySet()) {
            if ((mapFile1.containsKey(key) && mapFile2.containsKey(key))
                    && mapFile1.get(key).equals(mapFile2.get(key))) {
                sb.append("  ").append(key).append(": ").append(jointMap.get(key)).append("\n");
            } else if ((mapFile1.containsKey(key) && mapFile2.containsKey(key))
                    && !mapFile1.get(key).equals(mapFile2.get(key))) {
                sb.append("- ").append(key).append(": ").append(mapFile1.get(key)).append("\n");
                sb.append("+ ").append(key).append(": ").append(mapFile2.get(key)).append("\n");
            } else if (!mapFile1.containsKey(key)) {
                sb.append("+ ").append(key).append(": ").append(jointMap.get(key)).append("\n");
            } else {
                sb.append("- ").append(key).append(": ").append(jointMap.get(key)).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
