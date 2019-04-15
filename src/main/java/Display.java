import java.util.Arrays;

class Display {
    private Board board;
    private String newline = "\n";
    private String divider = "+-----------+" + newline;

    public Display(Board board) {
        this.board = board;
    }

    static void outMessage(String output) {
        System.out.println(output);
    }

    void showBoard() {
        String[][] boardInRows = processBoardIntoRows();
        System.out.print(renderRows(boardInRows));
    }

    private String[][] processBoardIntoRows() {
        String[] boardState = this.board.getCurrentBoard();

        return new String[][]{
                Arrays.copyOfRange(boardState, 0, 3),
                Arrays.copyOfRange(boardState, 3, 6),
                Arrays.copyOfRange(boardState, 6, 9)
        };
    }

    private String renderRows(String[][] rows) {
        String grid = divider;

        for (int i = 0; i < rows.length; i++) {
            int startingIndexOfRow = i * 3;
            String renderedRow = renderRow(rows[i], startingIndexOfRow);
            grid = grid.concat(renderedRow);
        }

        return grid;
    }

    private String renderRow(String[] rowState, int startIndex) {

        for (int i = 0; i < rowState.length; i++) {
            if (rowState[i].equals("")) {
                String output = Integer.toString(startIndex + i);
                rowState[i] = Colour.faded(output);
            }
        }

        String left = rowState[0];
        String center = rowState[1];
        String right = rowState[2];

        return String
                .format("| %s | %s | %s |", left, center, right)
                .concat(newline)
                .concat(divider);
    }
}
