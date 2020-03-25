package util;

public class Point {
	public double x;
	public double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return String.format("(%.2f, %.2f)", x, y);
	}
	
	public static double findDistance(Point a, Point b) {
		double legA = Math.abs(a.x - b.x);
		double legB = Math.abs(a.y -  b.y);
		double distance = Math.sqrt(legA * legA + legB * legB);
		return distance;
	}
}
