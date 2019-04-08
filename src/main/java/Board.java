public class Board {
    private void renderDivider() {
        String divider = "+-----------+";
        System.out.println(divider);
    }

    private void renderRow() {
        String left = "X";
        String center = "X";
        String right = "X";

        String row = String.format("| %s | %s | %s |", left, center, right);
        System.out.println(row);
    }

    public Integer sum(int i, int i1) {
        return i + i1;
    }

    public void render() {
        renderDivider();
        renderRow();
        renderDivider();
        renderRow();
        renderDivider();
        renderRow();
        renderDivider();
    }

    public void hello() {
        System.out.println("Hello World!");
    }
}
