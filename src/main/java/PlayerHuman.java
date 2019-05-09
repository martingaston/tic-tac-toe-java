import java.util.Scanner;

public class PlayerHuman implements Player {
    private final String symbol;
    private final Board board;
    private final IO io;

    public PlayerHuman(String symbol, Board board, IO io) {
        this.symbol = symbol;
        this.board = board;
        this.io = io;
    }

    public PlayerHuman(String symbol, Board board) {
        this(symbol, board, new IO(new Scanner(System.in)));
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNextMove() {
        int desiredCell = getAnInteger();

        while (!board.available().contains(desiredCell)) {
            invalidMove();
            desiredCell = getAnInteger();
        }

        return desiredCell;
    }

    private int getAnInteger() {
        while (!io.hasNextInt()) {
            invalidMove();
            io.next();
        }
        return computerise(io.nextInt());
    }

    private int computerise(int oneIndexedNumber) {
        return oneIndexedNumber - 1;
    }

    private void invalidMove() {
        Display.outMessage(Messages.invalidMove());
    }
}