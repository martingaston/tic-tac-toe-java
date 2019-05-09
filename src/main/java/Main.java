import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Shutdown());

        Game.play(args);
        System.exit(0);
    }
}
