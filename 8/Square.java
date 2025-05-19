import java.text.DecimalFormat;

/**
 * A square implementation of Shape
 */
public class Square extends Shape {
	public Square(double length) {
		super(length);
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getArea() {
		double area = (length == 0) ? 0.0 : length * length;
		return format(area);
	}
	public double getPerimeter() {
		double perimeter = (length == 0) ? 0.0 : 4 * length;
		return format(perimeter);
	}
	/**
	 * Transforms the double into a String to apply formatting, and then uses Double.parseDouble to convert the formatted String back into a double value
	 * @param value the value of area or perimeter
	 * @return the format of the value
	 */
	private double format(double value) {
		DecimalFormat df = new DecimalFormat("0.0#");
		return Double.parseDouble(df.format(value));
	}
}
