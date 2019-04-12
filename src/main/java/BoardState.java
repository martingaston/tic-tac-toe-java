public class BoardState {
    private String[] board;

    public BoardState() {
        board = new String[] {
            "", "", "",
            "", "", "",
            "", "", ""
        };
    }

    public String[] getCurrentBoard() {
        return board;
    }

    public String[] updateBoard(int position, Player player) {
        if (board[position].isEmpty()) {
            board[position] = player.getSymbol();
        }
        return board;
    }
}
