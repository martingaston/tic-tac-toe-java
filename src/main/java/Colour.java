public class Colour {
    private static String RESET ="\033[0m";
    private static String DARK_GREY = "\033[38;5;242m";

    public static String grey(String message) {
        return DARK_GREY + message + RESET;
    }
}