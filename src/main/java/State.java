import java.util.List;

public interface State {
    GameModes mode();

    BoardModes boardMode();

    List<String> contents();

    Players players();

    Board board();

    String lastMove();
}
