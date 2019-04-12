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
        return input.nextInt();
    }
}
