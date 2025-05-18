/**
 * Abstract class representing informations of a geometric shape
 */
import java.text.DecimalFormat;
public abstract class Shape {
	/**
	 * The characteristic length of the shape
	 * Ford circle, the characteristic length represents diameter
	 */
	protected double length;
	/**
	 * Sets the characteristic length of the shape
	 * @param length the characteristic length to set
	 */
    public abstract void setLength(double length);
    /**
     * Calculates the area of the shape
     * @return the area of the shape
     */
    public abstract double getArea();
    /**
     * Calculates the perimeter of the shape
     * @return the perimeter of the shape
     */
    public abstract double getPerimeter();
    /**
     * Return a formatted String with area and perimeter
     * @return information String of the shape
     */
    public String getInfo() {
        double area = getArea();
        double perimeter = getPerimeter();
        DecimalFormat df = new DecimalFormat("0.0#");
        String areaStr = (area == 0) ? "0.0" : df.format(area);
        String periStr = (perimeter == 0) ? "0.0" : df.format(perimeter);
        return "Area = " + areaStr + ", Perimeter = " + periStr;
    }
}