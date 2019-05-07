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
}
