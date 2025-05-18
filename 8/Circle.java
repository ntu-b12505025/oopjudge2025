/**
 * A circle implementation of Shape
 */
public class Circle extends Shape{
	public void setLength(double length) {
		this.length = length;
	}
	public double getArea() {
		double radius = length / 2;
		return Math.PI * radius * radius;
	}
	public double getPerimeter() {
		return Math.PI * length;
	}
}
