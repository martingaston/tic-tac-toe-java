import java.util.List;

public interface GameState {
    GameModes mode();

    List<String> contents();

    Players players();

    BoardModes board();

    String lastMove();
}
