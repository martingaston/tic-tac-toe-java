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
        setBoardState(boardState);
    }

    String[] getCurrentBoard() {
        return board;
    }

    private void setBoardState(String[] boardState) {
        this.board = removeBoardStateSpaces(boardState);
    }

    private String[] removeBoardStateSpaces(String[] boardState) {
        for (int i = 0; i < boardState.length; i++) {
            if (boardState[i].equals(" ")) {
                boardState[i] = "";
            }
        }
        return boardState;
    }

    public String[] addMoveToBoard(int position, Player player) {
        if (board[position].isEmpty()) {
            board[position] = player.getSymbol();
        }
        return board;
    }
}