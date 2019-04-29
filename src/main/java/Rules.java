import java.util.ArrayList;
import java.util.List;

public class Rules {
    private Board board;
    private int boardSideLength;
    private List<List<Integer>> winningMoves;

    public Rules(Board board) {
        this.board = board;
        this.boardSideLength = board.getSideLength();
        generateWinningMovesFromBoard();
    }

    private void generateWinningMovesFromBoard() {
        this.winningMoves = new ArrayList<>();

        addHorizontalAndVerticalWinConditions();
        addDiagonalWinConditions();
    }

    private void addHorizontalAndVerticalWinConditions() {
        List<Integer> horizontalMove;
        List<Integer> verticalMove;
        for (int row = 0; row < this.boardSideLength; row++) {
            horizontalMove = new ArrayList<>();
            verticalMove = new ArrayList<>();

            addNextHorizontalAndVerticalWinCondition(horizontalMove, verticalMove, row);
            addWinningPositionsToWinningMoves(horizontalMove, verticalMove);
        }
    }

    private void addNextHorizontalAndVerticalWinCondition(List<Integer> horizontalMove, List<Integer> verticalMove, int row) {
        for (int column = 0; column < this.boardSideLength; column++) {
            horizontalMove.add(column + this.boardSideLength * row);
            verticalMove.add(row + this.boardSideLength * column);
        }
    }

    private void addDiagonalWinConditions() {
        List<Integer> diagonalLeftMove = new ArrayList<>();
        List<Integer> diagonalRightMove = new ArrayList<>();

        for (int row = 0; row < this.boardSideLength; row++) {
            diagonalLeftMove.add(row + (row * this.boardSideLength));
            diagonalRightMove.add(this.boardSideLength - 1 + (row * this.boardSideLength) - row);

        }

        addWinningPositionsToWinningMoves(diagonalLeftMove, diagonalRightMove);
    }

    private void addWinningPositionsToWinningMoves(List<Integer> firstMove, List<Integer> secondMove) {
        winningMoves.add(firstMove);
        winningMoves.add(secondMove);
    }

    public boolean hasWinningMove(Player player) {

        for (List<Integer> move : this.winningMoves) {
            if (playerHasValidWinCondition(move, player)) {
                return true;
            }
        }

        return false;
    }

    private boolean playerHasValidWinCondition(List<Integer> move, Player player) {
        for (int cellIndex : move) {
            if (!playerOccupiesCell(cellIndex, player)) {
                return false;
            }
        }

        return true;
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
