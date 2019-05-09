import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
