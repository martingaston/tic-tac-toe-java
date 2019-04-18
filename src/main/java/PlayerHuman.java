import java.util.Scanner;

public class PlayerHuman implements Player {
    private String symbol;

    public PlayerHuman(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNextMove() {
        Scanner input = new Scanner(System.in);
        return computerise(input.nextInt());
    }

    private int computerise(int oneIndexedNumber) {
        return oneIndexedNumber - 1;
    }
}
