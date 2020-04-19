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

	public static Point findIntersection(Line l1, Line l2) {
		/*
		 * method should return intersection point if one exists (otherwise null)
		 */
		double m1 = l1.slope;
		double m2 = l2.slope;
		double b1 = l1.yInt;
		double b2 = l2.yInt;
		if (Utils.doubleEquals(m1, m2)) {
			return null;
		}
		// System.out.println("equation one: y = " + m1 + "x + " + b1 + "; equation two:
		// y = " + m2 + "x + " + b2);
		double xInt = Utils.doubleDivide(b2 - b1, m1 - m2);
		double yInt = m1 * xInt + b1;
		return new Point(xInt, yInt);
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
