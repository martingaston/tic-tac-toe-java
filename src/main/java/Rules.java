import java.util.ArrayList;
import java.util.List;

public class Rules {
    private Board board;

    public Rules(Board board) {
        this.board = board;
    }

    public boolean hasWinningMove(Player player) {
        List<List<Integer>> winningMoves = new ArrayList<>();
        List<Integer> horizontalMove;
        List<Integer> verticalMove;
        List<Integer> diagonalLeftMove;
        List<Integer> diagonalRightMove;

        int sideLength = (int) Math.sqrt(board.getTotalCells());

        diagonalLeftMove = new ArrayList<>();
        diagonalRightMove = new ArrayList<>();

        for (int row = 0; row < sideLength; row++) {
            horizontalMove = new ArrayList<>();
            verticalMove = new ArrayList<>();


            for (int column = 0; column < sideLength; column++) {
                horizontalMove.add(column + sideLength * row);
                verticalMove.add(row + sideLength * column);
            }

            winningMoves.add(horizontalMove);
            winningMoves.add(verticalMove);

            diagonalLeftMove.add(row + (row * sideLength));
            diagonalRightMove.add(sideLength - 1 + (row * sideLength) - row);
        }

        winningMoves.add(diagonalLeftMove);
        winningMoves.add(diagonalRightMove);

        for (List<Integer> move : winningMoves) {
            if (playerHasValidWinCondition(move, player)) {
                return true;
            }
        }

        return false;
    }
    
    private boolean playerHasValidWinCondition(List<Integer> move, Player player) {
        return playerOccupiesCell(move.get(0), player) &&
                playerOccupiesCell(move.get(1), player) &&
                playerOccupiesCell(move.get(2), player);
    }

    boolean isNotValidMove(Player player) {
        int desiredCellNumber = player.getMove();
        int totalBoardCells = board.getTotalCells();

        if (desiredCellNumber < 0 || desiredCellNumber > totalBoardCells - 1) {
            return true;
        }

        Cell desiredCell = board.getCellFromBoardPosition(desiredCellNumber);
        return desiredCell.isOccupied();
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
