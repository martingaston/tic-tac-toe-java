import java.util.HashMap;
import java.util.Map;

public class Messages {
    private Map<String, String> standardMessage = new HashMap<>();
    private Map<String, String> formatMessage = new HashMap<>();

    public Messages() {
        standardMessage.put("gameTitle", "TIC TAC TOE");
        standardMessage.put("gameIntro", "The classic game of noughts and crosses! Turn friends into enemies as 2 players take turns marking spaces in a 3x3 grid. Win short-lived glory by succeeding in placing three marks on the any horizontal, vertical or diagonal direction.");
        standardMessage.put("gameInstructions", "Input numbers between 0-8 on alternative turns to place your mark in the 3x3 grid");
        standardMessage.put("gameOverDraw", "Bad luck! It's a draw!");

        formatMessage.put("playerTurn", "Player %s's turn");
        formatMessage.put("gameOverWin", "Player %s wins!");
    }

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

    String getIntro() {
        return standardMessage.get("gameTitle") + "\n" +
                standardMessage.get("gameIntro") +  "\n" +
                standardMessage.get("gameInstructions");
    }
}
