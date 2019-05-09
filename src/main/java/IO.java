import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IO {
    private Scanner in;

    public IO(Scanner in) {
        this.in = in;
    }

    public int nextInt() {
        return in.nextInt();
    }

    public void next() {
        in.next();
    }

    public boolean hasNextInt() {
        return in.hasNextInt();
    }

    public static List<String> gameIn() {
        String content = "";

        try {
            content = new String (Files.readAllBytes(Paths.get("game.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(content.split(","));
    }

    public static void gameOut(String contents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"));
        writer.write(contents);
        writer.close();
    }

    public static void closeGame() throws IOException {
        File file = new File("game.txt");
        file.delete();
    }
}
