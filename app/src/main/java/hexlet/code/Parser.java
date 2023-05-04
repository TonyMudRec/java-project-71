package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws IOException {
        Map<String, Object> mapFile = new HashMap<>();
        try {
            Path path = Paths.get(filepath).toAbsolutePath().normalize();
            ObjectMapper om = new ObjectMapper();
            String content = new String(Files.readAllBytes(path));
            mapFile = om.readValue(content, HashMap.class);
        } catch (NullPointerException e) {
            System.out.println("File '" + filepath + "' does not exist");
        }
        return mapFile;
    }
}
