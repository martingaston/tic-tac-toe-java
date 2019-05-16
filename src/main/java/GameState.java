import java.util.List;

public interface GameState {
    GameModes mode();

    BoardModes boardMode();

    List<String> contents();

    Players players();

    Board board();

    String lastMove();
}
