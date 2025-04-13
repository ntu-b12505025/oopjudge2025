/**
 * The Greencrud class provides a method to calculate the population of green crud based on the Fibonacci sequence
 */
public class GreenCrud {
	/**
	 * Using the for statement to calculates the population which increases every five days following the Fibonacci sequence
	 * 
	 * @param initialSize the initial population
	 * @param days the passed days
	 * @return the population after days
	 */
	public int calPopulation(int initialSize, int days) {
		if (days < initialSize) {
			return initialSize;
		}
		int n = days / 5;
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
	 * Main method to test the calPopulation method
	 * 
	 * @param arg command-line argument
	 */
	public static void main(String[] arg) {
		GreenCrud gc = new GreenCrud();
		System.out.println(gc.calPopulation(6, 15));
		System.out.println(gc.calPopulation(10, 17));
		System.out.println(gc.calPopulation(3, 20));
	}
}
