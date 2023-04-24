package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(
        name = "hello",
        version = "1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class HelloCommand implements Runnable {
    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish"
    )
    private String format;

    @Parameters(
            paramLabel = "filepath1",
            description = "path to first file")
    private String filepath1;
    @Parameters(
            paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;

    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
