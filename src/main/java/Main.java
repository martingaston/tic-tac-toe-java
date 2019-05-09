public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Shutdown());

        Game game = new Game();
        game.play();
        System.exit(0);
    }
}
