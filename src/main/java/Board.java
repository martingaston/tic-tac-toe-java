import java.util.Arrays;

public class Board {
    public void render(String[] boardState) {
        String[] topRow = Arrays.copyOfRange(boardState, 0, 3);
        String[] middleRow = Arrays.copyOfRange(boardState, 3, 6);
        String[] bottomRow = Arrays.copyOfRange(boardState, 6, 9);

        renderDivider();
        renderRow(topRow);
        renderDivider();
        renderRow(middleRow);
        renderDivider();
        renderRow(bottomRow);
        renderDivider();
    }

    private void renderDivider() {
        String divider = "+-----------+";
        System.out.println(divider);
    }

    private void renderRow(String[] rowState) {
        String left = rowState[0];
        String center = rowState[1];
        String right = rowState[2];

        String row = String.format("| %s | %s | %s |", left, center, right);
        System.out.println(row);
    }
}
