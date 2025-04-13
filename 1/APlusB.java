/**
 * The APlusB class provides a method to compute the sum of two integers
 */
public class APlusB {
	/**
	 * method adds a and b, which are in the range [-1000000, 1000000], and returns the sum
	 * 
	 * @param a the first integer
	 * @param b the second integer
	 * @return the sum of a and b
	 */
	public static int plus(int a, int b) {
		return a + b;
	}
	/**
	 * Main method to test the plus method
	 * 
	 * @param arg command-line arguments
	 */
	public static void main(String[] arg) {
		System.out.println(APlusB.plus(1, 3));
		System.out.println(APlusB.plus(-100, 99));
		System.out.println(APlusB.plus(999, 1));
	}
}
