/**
 * Determines whether a given year is a leap year
 */
public class IsLeapYear {
	/**
	 * using if-else statement to determine a given year
	 * A year that is divisible by 400 is a leap year.
	 * A year that is divisible by 4 but not divisible by 100 is also a leap year.
	 * All other years are not leap years.
	 * 
	 * @param year a given year
	 * @return is leap year or not
	 */
	public boolean determine(int year) {
		if (year % 400 == 0) {
			return true;
		} else if (year % 4 == 0 && year % 100 !=0) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * main method to test the determine method
	 * 
	 * @param arg command-line argument
	 */
	public static void main(String[] arg) {
		IsLeapYear ily = new IsLeapYear();
		System.out.println(ily.determine(2014));
		System.out.println(ily.determine(2004));
		System.out.println(ily.determine(2100));
	}
}
