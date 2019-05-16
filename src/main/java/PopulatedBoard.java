public class PopulatedBoard {
    public static Board from(GameState state) {
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
}