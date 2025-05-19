import java.text.DecimalFormat;

/**
 * A circle implementation of Shape
 */
public class Circle extends Shape{
	public Circle(double length) {
		super(length);
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getArea() {
		double radius = length / 2;
		double area = (length == 0) ? 0.0 : Math.PI * radius * radius;
		return format(area);
	}
	public double getPerimeter() {
		double perimeter = (length == 0) ? 0.0 : Math.PI * length;
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
