public class Board {
    private String[] board;

    public Board() {
        this.board = new String[] {
                "", "", "",
                "", "", "",
                "", "", ""
        };
    }

    public Board(String [] boardState) {
        setBoard(boardState);
    }

    private void setBoard(String[] boardState) {
        this.board = removeBoardStateSpaces(boardState);
    }

    String[] getCurrentBoard() {
        return board;
    }

    public String[] updateBoard(int position, Player player) {
        if (board[position].isEmpty()) {
            board[position] = player.getSymbol();
        }
        return board;
    }

    private String[] removeBoardStateSpaces(String[] boardState) {
        for (int i = 0; i < boardState.length; i++) {
            if (boardState[i].equals(" ")) {
                boardState[i] = "";
            }
        }
        return boardState;
    }
}