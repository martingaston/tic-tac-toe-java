import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Settings settings = new Settings(args);
        Game.play(settings);
    }
}
