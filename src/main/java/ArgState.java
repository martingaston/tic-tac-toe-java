import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgState implements GameState {
    private GameModes mode;
    private BoardModes board;
    private List<String> contents;
    private Players players;
    private String lastMove;

    public ArgState(String[] args) {
        Map<String, String> parsedArgs = parseArgs(args);

        String boardArg = parsedArgs.getOrDefault("board", "");
        String modeArg = parsedArgs.getOrDefault("mode", "");
        board = BoardModes.nameOf(boardArg);
        mode = GameModes.nameOf(modeArg);
    }

    public Map<String, String> parseArgs(String[] args) {
        Pattern argStructure = Pattern.compile("^--(\\w+)=([\\w|-]+)$");
        Map<String, String> argMap = new HashMap<>();

        for (String arg : args) {
            Matcher matchedArg = argStructure.matcher(arg);
            if (matchedArg.matches()) {
                argMap.put(matchedArg.group(1), matchedArg.group(2));
            }
        }

        return argMap;
    }

    @Override
    public GameModes mode() {
        return mode;
    }

    @Override
    public List<String> contents() {
        return null;
    }

    @Override
    public Players players() {
        return null;
    }

    @Override
    public BoardModes board() {
        return board;
    }

    @Override
    public String lastMove() {
        return null;
    }
}
