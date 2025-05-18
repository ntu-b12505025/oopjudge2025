/**
 * A triangle implementation of Shape
 */
public class Triangle extends Shape{
	public Triangle(double length) {
		super(length);
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getArea() {
		return Math.sqrt(3) / 4 * length * length;
	}
	public double getPerimeter() {
		return 3 * length;
	}
}
