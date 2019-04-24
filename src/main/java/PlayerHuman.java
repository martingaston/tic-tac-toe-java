import java.util.Scanner;

public class PlayerHuman implements Player {
    private String symbol;
    private int move;
    private Rules rules;

    public PlayerHuman(String symbol, Rules rules) {
        this.symbol = symbol;
        this.rules = rules;
    }

    public PlayerHuman(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNextMove() {
        Scanner input = new Scanner(System.in);
        this.move = getAnInteger(input);

        while (rules.isNotValidMove(this)) {
            invalidMove();
            this.move = getAnInteger(input);
        }

        return this.move;
    }

    public int getMove() {
        return this.move;
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