public class Rules {
    private Board board;
    public Rules(Board board) {
        this.board = board;
    }

    public boolean hasWinningMove(Player player) {
        boolean matchFound = false;
        String playerSymbol = player.getSymbol();

        int[][] winningMoves = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] move : winningMoves) {
            if (playerHasCompleteRow(move, playerSymbol)) {
                matchFound = true;
            }
        }

        return matchFound;
    }

    private boolean playerHasCompleteRow(int[] move, String playerSymbol) {
        String[] boardState = this.board.getCurrentBoard();
        return boardState[move[0]].equals(playerSymbol) &&
                boardState[move[1]].equals(playerSymbol) &&
                boardState[move[2]].equals(playerSymbol);
    }

    public boolean gameIsOver() {
        for (String cell : this.board.getCurrentBoard()) {
            if (cell.isEmpty()) {
                return false;
            }
        }

        return true;
    }
}
