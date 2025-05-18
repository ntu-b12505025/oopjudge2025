/**
 * Factory class for creating Shape objects
 */
public class ShapeFactory {
	/**
	 * Enum representing shape types
	 */
	public enum Type{
		Triangle,
		Square,
		Circle
	}
	/**
	 * Creates a shape based on the type and length provided
	 * @param shapeType the type of shape
	 * @param length the characteristic length
	 * @return a Shape
	 */
	public Shape createShape(Type shapeType, double length) {
		Shape shape = null;
		switch (shapeType) {
			case Triangle:
				shape = new Triangle(length);
				break;
			case Square: 
				shape = new Square(length);
				break;
			case Circle:
				shape = new Circle(length);
				break;
		}
		if (shape != null) {
			shape.setLength(length);
		}
		return shape;
	}
	/**
	 * Main method to test Shape, Triangle, Square, Circle, and ShapeFactory class
	 * @param args command-line argument
	 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape triangle = shapeFactory.createShape(ShapeFactory.Type.Triangle, 7.5);
		Shape square = shapeFactory.createShape(ShapeFactory.Type.Square, 5);
		Shape circle = shapeFactory.createShape(ShapeFactory.Type.Circle, 5);
		System.out.println(triangle.getInfo());
		System.out.println(square.getInfo());
		System.out.println(circle.getInfo());
		System.out.println(square.getArea() > triangle.getArea());
		System.out.println(square.getPerimeter() > circle.getPerimeter());
		triangle.setLength(10.5);
		square.setLength(3.2);
		circle.setLength(0);
		System.out.println(triangle.getInfo());
		System.out.println(square.getInfo());
		System.out.println(circle.getInfo());
		System.out.println(square.getArea() > triangle.getArea());
		System.out.println(square.getPerimeter() > circle.getPerimeter());
	}
}
