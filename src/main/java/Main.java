public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.intro();
        do {
            game.newTurn();
            game.processTurn();
        } while (!game.isGameOver());
        game.gameEnd();
        System.exit(0);
    }
}
