package hexlet.code;

import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "./app/build/install/app/bin/app",
        version = "1.2",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {

//    @CommandLine.Option(
//            names = {"-f", "--format"},
//            description = "output format [default: stylish]",
//            defaultValue = "stylish"
//    )
//    static private String format;

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
        try {
            System.out.println(Differ.generate(filepath1, filepath2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
