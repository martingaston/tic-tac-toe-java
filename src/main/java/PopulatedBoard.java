public class PopulatedBoard {
    public static Board from(State state) {
        if(state.contents().size() != 9 && state.contents().size() != 16) {
            return new Board();
        }

        int sideLength = (int) Math.sqrt(state.contents().size());
        Board newBoard = new Board(sideLength);

        for (int i = 0; i < state.contents().size(); i++) {
            //TODO make this more readable by creating symbol classes
            String currentSymbol = state.contents().get(i);
            if (currentSymbol.equals(state.players().playerCross().symbol().toString())) {
                newBoard.add(i, state.players().playerCross().symbol());
            } else if (currentSymbol.equals(state.players().playerNought().symbol().toString())) {
                newBoard.add(i, state.players().playerNought().symbol());
            }
        }

        return newBoard;
    }
}