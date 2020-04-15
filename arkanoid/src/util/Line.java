package util;

public class Line {

	protected double slope;
	protected double yInt;

	public Line(double slope, double yInt) {
		this.slope = slope;
		this.yInt = yInt;
	}

	public Line(Point p1, Point p2) {
		slope = Segment.findSlope(p1, p2);
		yInt = Segment.findYIntercept(p1, slope);
	}

	public String toString() {
		return String.format("y = %.2f * x + %.2f", slope, yInt);
	}

	public double getSlope() {
		return slope;
	}

	public double getyInt() {
		return yInt;
	}

	public double getA() {
		return slope;
	}

	public double getB() {
		return -1.0;
	}

	public double getC() {
		return -yInt;
	}

	public double calculateY(double x) {
		return slope * x + yInt;
	}
}
