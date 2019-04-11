import java.util.Arrays;

class Display {
    private Board board;

    public Display(Board board) {
        this.board = board;
    }

    static void outBoard (String output) { System.out.print(output); }

    void showBoard() {
        System.out.print(renderBoardFromState());
    }

    static void outMessage(String output) {
        System.out.println(output);
    }

    private String newline = "\n";
    private String divider = "+-----------+" + newline;

    private String renderBoardFromState() {
        String[] boardState = this.board.getCurrentBoard();

        String[][] rows = new String[][] {
                Arrays.copyOfRange(boardState, 0, 3),
                Arrays.copyOfRange(boardState, 3, 6),
                Arrays.copyOfRange(boardState, 6, 9)
        };

        String grid = divider;

        for (String[] row : rows) {
            String renderedRow = renderRow(row);
            grid = grid.concat(renderedRow);
        }

        return grid;
    }

    private String renderRow(String[] rowState) {

        for (int i = 0; i < rowState.length; i++) {
            if (rowState[i].equals("")) {
                rowState[i] = " ";
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
