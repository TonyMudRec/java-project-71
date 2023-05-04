package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {

    @Test
    void generateTestJson() {
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

        assertThat(Differ.generate(testFilePath1, testFilePath2)).isEqualTo(expected);
    }

    @Test
    void generateTestJsonYaml() {
        String testFilePath1 = "src/test/resources/files/file3.yaml";
        String testFilePath2 = "src/test/resources/files/file4.yaml";
        String expected = "{\n"
                + " - follow: false\n"
                + "   host: hexlet.io\n"
                + " - proxy: 123.234.53.22\n"
                + " - timeout: 50\n"
                + " + timeout: 20\n"
                + " + verbose: true\n"
                + "}";
        assertThat(Differ.generate(testFilePath1, testFilePath2)).isEqualTo(expected);
    }
}
