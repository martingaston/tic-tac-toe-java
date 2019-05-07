public class Display {
    private final Board board;
    private final String newline = "\n";

    public Display(Board board) {
        this.board = board;
    }

    static void outMessage(String output) {
        System.out.println(output);
    }

    private String faded(String message) {
        String ANSI_RESET = "\033[0m";
        String ANSI_DARK_GREY = "\033[38;5;242m";
        return ANSI_DARK_GREY + message + ANSI_RESET;
    }

    void showBoard() {
        System.out.print(renderRows());
    }

    private String generateDivider() {
        int cellLength = getCellLength();

        StringBuilder divider = new StringBuilder("+");
        int lineLength = getLineLength(cellLength);
        divider.append("-".repeat(lineLength));
        divider.append("+");
        divider.append(newline);

        return divider.toString();
    }

    private int getLineLength(int cellLength) {
        return cellLength * board.sideLength() - 1;
    }

    private int getCellLength() {
        return board.getTotalCells() > 10 ? 5 : 4;
    }

    private String renderRows() {
        int totalCells = board.getTotalCells();
        int cellsInRow = board.sideLength();

        StringBuilder grid = new StringBuilder(generateDivider());

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

            currentBoardCell = board.get(i);

            String output;
            if (currentBoardCell.isNotOccupied()) {
                int boardNumber = humanise(i);
                output = faded(renderOccupant(Integer.toString(boardNumber)));
            } else {
                output = renderOccupant(currentBoardCell);
            }

            renderedRowString.append(output);
            renderedRowString.append(" |");
        }

        renderedRowString.append(newline);
        renderedRowString.append(generateDivider());

        return renderedRowString.toString();
    }

    private String renderOccupant(Cell cell) {
        return renderOccupant(cell.getOccupant());
    }

    private String renderOccupant(String occupant) {
        return occupantNeedsPadding(occupant) ? " " + occupant : occupant;
    }

    private boolean occupantNeedsPadding(String occupant) {
        return board.getTotalCells() > 9 && occupant.length() == 1;
    }

    private int humanise(int zeroIndexedNumber) {
        return zeroIndexedNumber + 1;
    }
}
