import java.util.List;

public class PopulatedBoard {
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