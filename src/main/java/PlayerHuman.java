import java.util.Scanner;

public class PlayerHuman implements Player {
    private final String symbol;
    private final Board board;

    public PlayerHuman(String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNextMove() {
        Scanner input = new Scanner(System.in);
        int desiredCell = getAnInteger(input);

        while (!board.available().contains(desiredCell)) {
            invalidMove();
            desiredCell = getAnInteger(input);
        }

        return desiredCell;
    }

    private int getAnInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            invalidMove();
            scanner.next();
        }
        return computerise(scanner.nextInt());
    }

    private int computerise(int oneIndexedNumber) {
        return oneIndexedNumber - 1;
    }

    private void invalidMove() {
        Messages messages = new Messages();
        Display.outMessage(messages.invalidMove());
    }
}