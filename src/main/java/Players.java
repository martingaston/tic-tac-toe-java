import java.util.Scanner;

public class Players {
    private Player playerCross;
    private Player playerNought;
    private Player currentPlayer;

    Players(Board board) {
        Scanner input = new Scanner(System.in);
        int modeNumber = input.nextInt();
        switch(modeNumber) {
            case 1:
                this.playerCross = new PlayerHuman("X");
                this.playerNought = new PlayerHuman("O");
                break;
            case 2:
                this.playerCross = new PlayerHuman("X");
                this.playerNought = new PlayerCPU("O", board);
                break;
        }
        this.currentPlayer = playerCross;
    }

    public Players(Player playerCross, Player playerNought) {
        this.playerCross = playerCross;
        this.playerNought = playerNought;
        this.currentPlayer = this.playerCross;
    }

    public void nextTurn() {
        if (currentPlayer == playerCross) {
            currentPlayer = playerNought;
        } else {
            currentPlayer = playerCross;
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
