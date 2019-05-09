public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Shutdown());

        Game.play(args);
        System.exit(0);
    }
}
