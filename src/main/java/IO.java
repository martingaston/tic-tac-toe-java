import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class IO {
    private final Scanner in;

    public IO(Scanner in) {
        this.in = in;
    }

    public static List<String> gameIn() {
        String content = "";

        File f = new File("game.txt");
        if (!f.exists()) {
            return new LinkedList<>();
        }

        try {
            content = new String(Files.readAllBytes(Paths.get("game.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(content.split(","));
    }

    public static void gameOut(State state) throws IOException {
        String boardMode = Integer.toString(BoardModes.id(state.boardMode()));
        String gameMode = Integer.toString(GameModes.id(state.mode()));
        String playerCrossSymbol = state.players().playerCross().symbol().toString();
        String playerNoughtSymbol = state.players().playerNought().symbol().toString();
        String lastPlayer = state.players().getCurrentPlayer().symbol().toString();
        List<String> boardAsList = state.board().toList();

        List<String> boardState = new LinkedList<>(Arrays.asList(
                boardMode,
                gameMode,
                playerCrossSymbol,
                playerNoughtSymbol,
                lastPlayer
        ));
        boardState.addAll(boardAsList);

        String boardCSV = String.join(",", boardState);
        BufferedWriter writer = new BufferedWriter(new FileWriter("game.txt"));
        writer.write(boardCSV);
        writer.close();
    }

    public static void closeGame() {
        File file = new File("game.txt");
        file.delete();
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
