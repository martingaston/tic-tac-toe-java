public class Rules {
    private Board board;

    public Rules(Board board) {
        this.board = board;
    }

    public boolean hasWinningMove(Player player) {
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
            if (playerHasValidWinCondition(move, player)) {
                return true;
            }
        }

        return false;
    }

    private boolean playerHasValidWinCondition(int[] move, Player player) {
        return playerOccupiesCell(move[0], player) &&
                playerOccupiesCell(move[1], player) &&
                playerOccupiesCell(move[2], player);
    }

    private boolean playerOccupiesCell(int index, Player player) {
        String playerSymbol = player.getSymbol();
        return board.getCellFromBoardPosition(index).getOccupant().equals(playerSymbol);
    }

    public boolean gameIsOver() {
        for (int i = 0; i < board.getTotalCells(); i++) {
            if (board.getCellFromBoardPosition(i).isNotOccupied()) {
                return false;
            }
        }

        return true;
    }
}
