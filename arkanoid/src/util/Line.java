package util;

public class Line {

	private double slope;
	private double yInt;

	public Line(double slope, double yInt) {
		this.slope = slope;
		this.yInt = yInt;
	}
	
	public String toString() {
		return String.format("y = %.2f * x + %.2f", slope, yInt);
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
}
