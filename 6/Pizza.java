/**
 * The Pizza class allows customization of the number of cheese, pepperoni, and ham toppings, calculation of pizza cost, and comparison between two pizzas
 */
public class Pizza {
	private String size;
	private int numOfCheese;
	private int numOfPepperoni;
	private int numOfHam;
	/**
	 * Default constructor
	 * Initializes a small pizza with 1 cheese, 1 pepperoni, and 1 ham topping
	 */
	public Pizza() {
		this.size = "small";
		this.numOfCheese = 1;
		this.numOfPepperoni = 1;
		this.numOfHam = 1;
	}
	/**
	 * Constructor with parameters to set
	 * @param size the size of the pizza
	 * @param numOfCheese the number of cheese toppings
	 * @param numOfPepperoni the number of pepperoni toppings
	 * @param numOfHam the number of ham toppings
	 */
	public Pizza(String size, int numOfCheese, int numOfPepperoni, int numOfHam) {
		this.size = size;
		this.numOfCheese = numOfCheese;
		this.numOfPepperoni = numOfPepperoni;
		this.numOfHam = numOfHam;
	}
	/**
	 * Gets the size of the pizza
	 * @return the size of the pizza
	 */
	public String getSize() {
		return size;
	}
	/**
	 * Sets the size of the pizza
	 * @param size the size of the pizza
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * Gets the number of cheese toppings
	 * @return the number of cheese toppings
	 */
	public int getNumberOfCheese() {
		return numOfCheese;
	}
	/**
	 * Sets the number of cheese toppings
	 * @param numOfCheese the number of cheese toppings
	 */
	public void setNumberOfCheese(int numOfCheese) {
		this.numOfCheese = numOfCheese;
	}
	/**
	 * Gets the number of pepperoni toppings
	 * @return the number of pepperoni toppings
	 */
	public int getNumberOfPepperoni() {
		return numOfPepperoni;
	}
	/**
	 * Sets the number of pepperoni toppings
	 * @param numOfPepperoni the number of pepperoni toppings
	 */
	public void setNumberOfPepperoni(int numOfPepperoni) {
		this.numOfPepperoni = numOfPepperoni;
	}
	/**
	 * Gets the number of ham toppings
	 * @return the number of ham toppings
	 */
	public int getNumberOfHam() {
		return numOfHam;
	}
	/**
	 * Sets the number of ham toppings
	 * @param numOfHam the number of ham toppings
	 */
	public void setNumberOfHam(int numOfHam) {
		this.numOfHam = numOfHam;
	}
	/**
	 * Use if statements to calculate the total cost of the pizza based on its size and toppings
	 * @return the total cost of the pizza
	 */
	public double calcCost() {
		int TotalTopping = numOfCheese + numOfPepperoni + numOfHam;
		double cost = 0;
		
		if (size.equalsIgnoreCase("small")) {
			cost = 10 + 2 * TotalTopping;
		} else if (size.equalsIgnoreCase("medium")) {
			cost = 12 + 2 * TotalTopping;
		} else if (size.equalsIgnoreCase("large")) {
			cost = 14 + 2 * TotalTopping;
		}
		return cost;
	}
	/**
	 * Compares two pizzas
	 * @param other the other pizza to compare to
	 * @return ture if the pizzas are the same; false otherwise
	 */
	public boolean equals(Pizza other) {
		return this.size.equals(other.size) && this.numOfCheese == other.numOfCheese && this.numOfPepperoni == other.numOfPepperoni && this.numOfHam == other.numOfHam;
	}
	/**
	 * Returns a string representation of the pizza
	 * @return a string with pizza size and number of each topping
	 */
	public String toString() {
		return "size = " + size + ", numOfCheese = " + numOfCheese + ", numOfPepperoni = " + numOfPepperoni + ", numOfHam = " + numOfHam;
	}
	/**
	 * Main method to test the Pizza class
	 * @param arg command-line argument
	 */
	public static void main(String arg[]) {
		Pizza pizza = new Pizza("large", 3, 1, 5);
		System.out.println(pizza.getSize());
		System.out.println(pizza.getNumberOfCheese());
		System.out.println(pizza.getNumberOfPepperoni());
		System.out.println(pizza.getNumberOfHam());
		pizza = new Pizza();
		pizza.setSize("medium");
		pizza.setNumberOfCheese(2);
		pizza.setNumberOfPepperoni(4);
		pizza.setNumberOfHam(1);
		System.out.println(pizza.getSize());
		System.out.println(pizza.getNumberOfCheese());
		System.out.println(pizza.getNumberOfPepperoni());
		System.out.println(pizza.getNumberOfHam());
		System.out.println(pizza.calcCost());
		System.out.println(pizza.toString());
		System.out.println(pizza.equals(new Pizza("large", 2, 4, 1)));
		System.out.println(pizza.equals(new Pizza()));
		System.out.println(pizza.equals(new Pizza("medium", 2, 4, 1)));
	}
}
