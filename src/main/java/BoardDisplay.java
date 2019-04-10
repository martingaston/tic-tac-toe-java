import java.util.Arrays;

public class BoardDisplay {
    public void display(String boardRender) {
        System.out.print(boardRender);
    }

    public String render(String[] boardState) {
        String divider = "+-----------+";
        String[] topRow = Arrays.copyOfRange(boardState, 0, 3);
        String[] middleRow = Arrays.copyOfRange(boardState, 3, 6);
        String[] bottomRow = Arrays.copyOfRange(boardState, 6, 9);
        String newline = "\n";

        return "" +
            divider + newline +
            renderRow(topRow) + newline +
            divider + newline +
            renderRow(middleRow) + newline +
            divider + newline +
            renderRow(bottomRow) + newline +
            divider + newline;
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

        return String.format("| %s | %s | %s |", left, center, right);
    }
}
