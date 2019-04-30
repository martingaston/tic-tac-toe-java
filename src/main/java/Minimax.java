public class Minimax {
    public static int optimal(int[] scores) {
        int max = Integer.MIN_VALUE;
        for (int number : scores) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
