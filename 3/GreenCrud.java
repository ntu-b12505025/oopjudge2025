/**
 * The GreenCrud class provides a method to calculate the population of green crud based on the Fibonacci sequence.
 */
public class GreenCrud {

    /**
     * Calculates the population size of green crud after a given number of days.
     * The population increases every 5 days following the Fibonacci sequence.
     *
     * @param initialSize the initial population in pounds (1 ≤ initialSize ≤ 10000)
     * @param days the number of days after (1 ≤ days ≤ 100)
     * @return the population size after the specified number of days
     */
    public int calPopulation(int initialSize, int days) {
        int n = days / 5;
        if (n == 0 || n == 1) {
            return initialSize;
        }
        int f1 = 1;
        int f2 = 1;

        for (int i = 2; i <= n; i++) {
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }

        return f2 * initialSize;
    }

    /**
     * Main method to test the calPopulation method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        GreenCrud gc = new GreenCrud();

        System.out.println(gc.calPopulation(6, 15));
        System.out.println(gc.calPopulation(10, 17));
        System.out.println(gc.calPopulation(3, 20));
    }
}
