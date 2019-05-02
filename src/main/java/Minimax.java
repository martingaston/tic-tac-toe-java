import java.util.Collections;

public class Minimax {
    private Player maximizer;
    private Player minimizer;
    private Board board;
    private Rules rules;

    public Minimax(Board board, Rules rules, Player maximizer, Player minimizer) {
        this.board = board;
        this.rules = rules;
        this.maximizer = maximizer;
        this.minimizer = minimizer;
    }

    private Integer evaluateBoard() {
        if (rules.hasWinningMove(maximizer)) {
            return 10;
        }

        if (rules.hasWinningMove(minimizer)) {
            return -10;
        }

        return 0;
    }

    public Integer minimax(int depth, boolean isMax) {
        int score = evaluateBoard();

        if (score == 10) {
            return score - depth;
        }

        if (score == -10) {
            return score + depth;
        }

        if (noMovesLeft()) {
            return 0;
        }

        if(isMax) {
            int best = Integer.MIN_VALUE;

            for (int index : board.available()) {
                board.addMove(index, maximizer);
                best = Integer.max(best,
                        minimax(depth + 1, !isMax));
            }

            return best;

        } else {
            int best = Integer.MAX_VALUE;

            return best;
        }
    }

    private boolean noMovesLeft() {
        return rules.gameIsOver();
    }
}
