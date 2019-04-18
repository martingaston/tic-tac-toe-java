import java.util.Scanner;

public class Player {
    private String symbol;

    public Player(String symbol) {
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
