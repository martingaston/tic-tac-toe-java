import java.util.HashMap;
import java.util.Map;

public class Messages {
    private Map<String, String> standardMessage = new HashMap<>();
    private Map<String, String> formatMessage = new HashMap<>();

    public Messages() {
        standardMessage.put("gameTitle", "TIC TAC TOE");
        standardMessage.put("gameIntro", "The classic game of noughts and crosses! Turn friends into enemies as 2 players take turns marking spaces in a 3x3 grid. Win short-lived glory by succeeding in placing three marks on the any horizontal, vertical or diagonal direction.");

        standardMessage.put("gameOverDraw", "Bad luck! It's a draw!");
        standardMessage.put("invalidMove", "Sorry, that move is invalid.\nPlease choose an unoccupied square between 1 and 9");
        standardMessage.put("setup", "Select a game mode:\n1. Human v Human\n2. Human v CPU\n3. CPU v CPU\n");

        formatMessage.put("gameInstructions", "Input numbers between 1-%s on alternative turns to place your mark in the %s grid.");
        formatMessage.put("playerTurn", "Player %s's turn");
        formatMessage.put("gameOverWin", "Player %s wins!");
    }

    String setupInstructions() {
        return standardMessage.get("setup");
    }

    String invalidMove() { return standardMessage.get("invalidMove"); }

    String playerWin(Player player) {
        String message = formatMessage.get("gameOverWin");
        return String.format(message, player.getSymbol());
    }

    String playersDraw() {
        return standardMessage.get("gameOverDraw");
    }

    String announcePlayerTurn(Player player) {
        String message = formatMessage.get("playerTurn");
        return String.format(message, player.getSymbol());
    }

    String getIntro(int totalCells) {
        int sideLength = (int) Math.sqrt(totalCells);
        String gridShape = sideLength + "x" + sideLength;

        String instructionsMessage = formatMessage.get("gameInstructions");
        String formattedInstructions = String.format(instructionsMessage, totalCells, gridShape);

        return standardMessage.get("gameTitle") + "\n" +
                standardMessage.get("gameIntro") +  "\n" +
                formattedInstructions;
    }
}
