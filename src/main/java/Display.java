public class Display {
    private Board board;
    private String newline = "\n";
    private String divider;

    public Display(Board board) {
        this.board = board;
        this.divider = generateDivider() + newline;
    }

    private String generateDivider() {

        int cellLength = 4;

        if (board.getTotalCells() > 10) {
            cellLength = 5;
        }

        StringBuilder divider = new StringBuilder();
        int rowLength = -2 + cellLength * board.getSideLength() + 1;
        divider.append("+");
        divider.append("-".repeat(rowLength));
        divider.append("+");

        return divider.toString();
    }

    static void outMessage(String output) {
        System.out.println(output);
    }

    private String faded(String message) {
        String ANSI_RESET ="\033[0m";
        String ANSI_DARK_GREY = "\033[38;5;242m";
        return ANSI_DARK_GREY + message + ANSI_RESET;
    }

    void showBoard() {
        System.out.print(renderRows());
    }

    private String renderRows() {
        int totalCells = board.getTotalCells();
        int cellsInRow = board.getSideLength();

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
                int boardNumber = humanise(i);
                output = faded(renderItem(Integer.toString(boardNumber)));
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
        return renderItem(cell.getOccupant());
    }

    private String renderItem(String occupant) {
        if (board.getTotalCells() > 9 && occupant.length() == 1) {
            return " " + occupant;
        }

        return occupant;
    }

    private int humanise(int zeroIndexedNumber) { return zeroIndexedNumber + 1; }
}
