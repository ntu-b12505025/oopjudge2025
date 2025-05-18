/**
 * A square implementation of Shape
 */
public class Square extends Shape {
	public void setLength(double length) {
		this.length = length;
	}
	public double getArea() {
		return length * length;
	}
	public double getPerimeter() {
		return 4 * length;
	}
}
