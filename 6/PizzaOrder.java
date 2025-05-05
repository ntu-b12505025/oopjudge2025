/**
 * The PizzaOrder class provides methods to set the number of pizzas, assign pizzas to the order, and calculate the total cost of the order
 */
public class PizzaOrder {
	private int numberPizzas;
	private Pizza pizza1;
	private Pizza pizza2;
	private Pizza pizza3;
	/**
	 * Sets the number of the pizzas and checks whether the value is within the valid range (1 to 3)
	 * @param numberPizzas the number of the pizzas
	 * @return true if number is valid, false otherwise
	 */
	public boolean setNumberPizzas(int numberPizzas) {
		if (numberPizzas >= 1 && numberPizzas <= 3) {
			this.numberPizzas = numberPizzas;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Set the first pizza
	 * @param pizza1 the first pizza object
	 */
	public void setPizza1(Pizza pizza1) {
		this.pizza1 = pizza1;
	}
	/**
	 * Set the second pizza
	 * @param pizza2 the second pizza object
	 */
	public void setPizza2(Pizza pizza2) {
		this.pizza2 = pizza2;
	}
	/**
	 * Set the third pizza
	 * @param pizza3 the third pizza object
	 */
	public void setPizza3(Pizza pizza3) {
		this.pizza3 = pizza3;
	}
	/**
	 * Use if statements to adds the price of each pizza in order
	 * @return the total price of the pizzas
	 */
	public double calcTotal() {
		double total = 0.0;
		if (numberPizzas >= 1 && pizza1 != null) {
            total += pizza1.calcCost();
        }
        if (numberPizzas >= 2 && pizza2 != null) {
            total += pizza2.calcCost();
        }
        if (numberPizzas == 3 && pizza3 != null) {
            total += pizza3.calcCost();
        }
        return total;
	}
	/**
	 * Main method to test the PizzaOrder Class
	 * @param args command-line argument
	 */
	public static void main(String[] args) {
		Pizza pizza1 = new Pizza("large", 1, 0, 1);
		Pizza pizza2 = new Pizza("medium", 2, 2, 5);
		Pizza pizza3 = new Pizza();
		PizzaOrder order = new PizzaOrder();
		System.out.println(order.setNumberPizzas(5));
		order.setNumberPizzas(2);
		order.setPizza1(pizza1);
		order.setPizza2(pizza2);
		System.out.println(order.calcTotal());
		order.setNumberPizzas(3);
		order.setPizza1(pizza1);
		order.setPizza2(pizza2);
		order.setPizza3(pizza3);
		System.out.println(order.calcTotal());
	}
}
