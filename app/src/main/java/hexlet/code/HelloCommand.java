package hexlet.code;

import picocli.CommandLine;

@CommandLine.Command(
        name = "hello",
        version = "1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class HelloCommand implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
