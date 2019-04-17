public class SproutDisplay {
    private SproutBoard board;
    private String newline = "\n";
    private String divider = "+-----------+" + newline;

    private String faded(String message) {
        String ANSI_RESET ="\033[0m";
        String ANSI_DARK_GREY = "\033[38;5;242m";
        return ANSI_DARK_GREY + message + ANSI_RESET;
    }

    public SproutDisplay(SproutBoard board) {
        this.board = board;
    }

    void showBoard() {
        System.out.print(renderRows());
    }

    private String renderRows() {
        int totalCells = board.getTotalCells();
        int cellsInRow = (int)Math.sqrt(totalCells);

        StringBuilder grid = new StringBuilder(divider);

        for (int i = 0; i < totalCells; i += cellsInRow) {
            String renderedRow = renderRow(i, i + cellsInRow);
            grid.append(renderedRow);
        }

        return grid.toString();
    }

    private String renderRow(int startIndex, int endIndex) {
        StringBuilder renderedRowString = new StringBuilder();
        Cell currentBoardCell;
        renderedRowString.append("|");

        for (int i = startIndex; i < endIndex; i++) {
            renderedRowString.append(" ");

            currentBoardCell = board.getCellFromBoardPosition(i);

            String output;
            if (currentBoardCell.isNotOccupied()) {
                int boardNumber = zeroIndexToOneIndex(i);
                output = faded(Integer.toString(boardNumber));
            } else {
                output = renderCell(currentBoardCell);
            }

            renderedRowString.append(output);
            renderedRowString.append(" |");
        }

        renderedRowString.append(newline);
        renderedRowString.append(divider);

        return renderedRowString.toString();
    }

    private String renderCell(Cell cell) {
        return cell.getOccupant();
    }

    private int zeroIndexToOneIndex(int zeroIndexedNumber) { return zeroIndexedNumber + 1; }
}
