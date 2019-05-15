import java.util.List;

public class PopulatedBoard {
    public static Board from(FileState state) {
        if(state.contents().size() != 9 && state.contents().size() != 16) {
            return new Board();
        }

        int sideLength = (int) Math.sqrt(state.contents().size());
        Board newBoard = new Board(sideLength);

        for (int i = 0; i < state.contents().size(); i++) {
            String currentSymbol = state.contents().get(i);
            if (currentSymbol.equals(state.players().playerCross().getSymbol())) {
                newBoard.add(i, state.players().playerCross());
            } else if (currentSymbol.equals(state.players().playerNought().getSymbol())) {
                newBoard.add(i, state.players().playerNought());
            }
        }

        return newBoard;
    }

    public static Board from(List<String> boardList, Player playerCross, Player playerNought) {
        if(boardList.size() != 9 && boardList.size() != 16) {
            return new Board();
        }

        int sideLength = (int) Math.sqrt(boardList.size());
        Board newBoard = new Board(sideLength);

        for (int i = 0; i < boardList.size(); i++) {
            String currentSymbol = boardList.get(i);
            if (currentSymbol.equals(playerCross.getSymbol())) {
                newBoard.add(i, playerCross);
            } else if (currentSymbol.equals(playerNought.getSymbol())) {
                newBoard.add(i, playerNought);
            }
        }

        return newBoard;
    }
}