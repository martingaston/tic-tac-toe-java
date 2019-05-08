public class Main {
    public static void main(String[] args) {
        //TODO ^--game=(.*)$ // regexp for GAME MODE
        //TODO ^--board=(.*)$ // regexp for BOARD SIZE

        Game game = new Game();
        game.play();
        System.exit(0);
    }
}
