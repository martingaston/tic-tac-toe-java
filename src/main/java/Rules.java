public class Rules {
    private Board board;
    private int[][] winningMoves = {
        {0,1,2},
        {3,4,5},
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
    };
    private int totalWinningMoves = winningMoves.length;

    public Rules() {

    }

    public Rules(Board board) {
        this.board = board;
    }

    public boolean hasWinningMove(Player player) {
        boolean matchFound = false;
        String[] boardState = this.board.getCurrentBoard();
        String playerSymbol = player.getSymbol();

        for (int i = 0; i < totalWinningMoves;i++) {
            int position1 = winningMoves[i][0];
            int position2 = winningMoves[i][1];
            int position3 = winningMoves[i][2];

            if (boardState[position1].equals(playerSymbol) &&
                boardState[position2].equals(playerSymbol) &&
                boardState[position3].equals(playerSymbol)) {
                matchFound = true;
            }
        }

        return matchFound;
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
