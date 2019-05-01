public class PlayerMinimax implements Player {
    private String symbol;
    private Rules rules;
    private Board board;
    private Players players;
    private int move;

    PlayerMinimax(String symbol, Rules rules, Board board, Players players) {
        this.symbol = symbol;
        this.rules = rules;
        this.board = board;
        this.players = players;
    }

    public int getMove() {
        return this.move;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int getNextMove() {
        Node<NodeValue> boardTree = Tree.makeNode(board, rules, this, players);
        NodeValue optimal = Minimax.optimal(boardTree);
        this.move = optimal.position();

        oneSecondSleep();
        return this.move;
    }

    private void oneSecondSleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
