package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) {
        Map<String, Object> mapFile = new HashMap<>();
        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        ObjectMapper om;
        try {
            if (filepath.endsWith("json")) {
                om = new ObjectMapper();
            } else /* if (filepath.endsWith("yaml")) */ {
                om = new YAMLMapper();
            }
            String content = new String(Files.readAllBytes(path));
            mapFile = om.readValue(content, HashMap.class);
        } catch (NullPointerException | IOException e) {
            System.out.println("File '" + filepath + "' does not exist, or cannot be reading");
        }
        return mapFile;
    }
}
