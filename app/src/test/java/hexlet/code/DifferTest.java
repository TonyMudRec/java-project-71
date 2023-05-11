package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generateTestSimpleJson() {
        String testFilePath1 = "src/test/resources/files/file1.json";
        String testFilePath2 = "src/test/resources/files/file2.json";
        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";

        assertThat(Differ.generate(testFilePath1, testFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    void generateTestHardJson() {
        String testFilePath1 = "src/test/resources/files/file3.json";
        String testFilePath2 = "src/test/resources/files/file4.json";
        String expected = "{\n"
                + "   chars1: [a, b, c]\n"
                + " - chars2: [d, e, f]\n"
                + " + chars2: false\n"
                + " - checked: false\n"
                + " + checked: true\n"
                + " - default: null\n"
                + " + default: [value1, value2]\n"
                + " - id: 45\n"
                + " + id: null\n"
                + " - key1: value1\n"
                + " + key2: value2\n"
                + "   numbers1: [1, 2, 3, 4]\n"
                + " - numbers2: [2, 3, 4, 5]\n"
                + " + numbers2: [22, 33, 44, 55]\n"
                + " - numbers3: [3, 4, 5]\n"
                + " + numbers4: [4, 5, 6]\n"
                + " + obj1: {nestedKey=value, isNested=true}\n"
                + " - setting1: Some value\n"
                + " + setting1: Another value\n"
                + " - setting2: 200\n"
                + " + setting2: 300\n"
                + " - setting3: true\n"
                + " + setting3: none\n"
                + "}";

        assertThat(Differ.generate(testFilePath1, testFilePath2, "stylish")).isEqualTo(expected);
    }

    @Test
    void generateTestYaml() {
        String testFilePath1 = "src/test/resources/files/file1.yaml";
        String testFilePath2 = "src/test/resources/files/file2.yaml";
        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";
        assertThat(Differ.generate(testFilePath1, testFilePath2, "stylish")).isEqualTo(expected);
    }
}
