package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "./app/build/install/app/bin/app",
        version = "2.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable {

    @CommandLine.Option(
            names = {"-f", "--format"},
            description = "output format [default: stylish]",
            defaultValue = "stylish"
    )
    private static String format;

    @CommandLine.Parameters(
            paramLabel = "filepath1",
            description = "path to first file")
    private static String filepath1;

    @CommandLine.Parameters(
            paramLabel = "filepath2",
            description = "path to second file")
    private static String filepath2;

    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
    @Override
    public Object call() {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return null;
    }
}
