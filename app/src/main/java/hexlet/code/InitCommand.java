package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "./app/build/install/app/bin/app",
        version = "1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class InitCommand implements Callable {
    @Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish"
    )
    static private String format;

    @Parameters(
            paramLabel = "filepath1",
            description = "path to first file")
    static private String filepath1;

    @Parameters(
            paramLabel = "filepath2",
            description = "path to second file")
    static private String filepath2;

    public static String getFormat() {
        return format;
    }

    public static String getFilepath1() {
        return filepath1;
    }

    public static String getFilepath2() {
        return filepath2;
    }

    @Override
    public Object call() {
        try {
            System.out.println(Differ.generate());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
