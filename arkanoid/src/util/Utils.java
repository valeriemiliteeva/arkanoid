package util;

import java.util.ArrayList;

public class Utils {

	static public boolean doubleEquals(double a, double b) {
		return Math.abs(a - b) < 1e-6;
	}

	static public boolean doubleGreater(double a, double b) {
		return a - b > -1e-6;
	}

	static public double doubleDivide(double a, double b) {
		return a / (doubleEquals(b, 0) ? 1e-6 : b);
	}
	
	public static <T extends Point> T findClosestPoint(Point start, ArrayList<T> points) {
		double minDistance = Double.MAX_VALUE;
		T closestPoint = null;
		for (T point : points) {
			double distance = Point.findDistance(point, start);
			if (distance <  minDistance) {
				minDistance = distance;
				closestPoint = point;
			}
		}
		return closestPoint;
	}

	static public double[] solveQuadraticFormula(double a, double b, double c) {
		if (Utils.doubleEquals(a, 0)) {
			return new double[] { - Utils.doubleDivide(c, b) };
		}
		double discriminant = b * b - 4 * a * c;
		if (discriminant < 0) {
			return new double[0];
		}
		return new double[] { (-b + Math.sqrt(discriminant)) / (2 * a), (-b - Math.sqrt(discriminant)) / (2 * a) };
	}

	public static boolean belongsToQuarterCircle(Point center, Point point, int quadrant) {
		if (quadrant == 1) {
			return point.x > center.x && point.y > center.y;
		} else if (quadrant == 2) {
			return point.x < center.x && point.y > center.y;
		} else if (quadrant == 3) {
			return point.x < center.x && point.y < center.y;
		} else if (quadrant == 4) {
			return point.x > center.x && point.y < center.y;
		}
		throw new RuntimeException("needs improvement");
	}
	
	public static ArrayList<PointWithQuadrant> findCircleAndSegIntersection(Point center, double r, Segment seg, int quadrant) {
		double m = seg.findSlope();
		double b = seg.findYIntercept();
		double c = center.x;
		double d = center.y;
		double[] xVals = solveQuadraticFormula(1 + m * m, 2  * (m * b - m * d - c), c * c + (b - d) * (b - d) - r * r);
		ArrayList<PointWithQuadrant> points = new ArrayList<>();
		for (int i = 0; i < xVals.length; i++) {
			PointWithQuadrant point = new PointWithQuadrant(xVals[i], m * xVals[i] + b, quadrant);
			if (Segment.isBetween(seg, point)) {
				System.out.println("isBetween");
			}
			if (belongsToQuarterCircle(center, point, quadrant) && Segment.isBetween(seg, point)) {
				points.add(point);
			}
		}
		return points;
	}
	
	public static Line findReflectionEquation(Line light, Line wall) {
		double a = light.getA();
		double b = light.getB();
		double c = light.getC();
		double d = wall.getA();
		double e = wall.getB();
		double f = wall.getC();
		double h = ((c * d) - (a * f)) / ((b * d) - (a * e));
		double k = ((c * e) - (b * f)) / ((a * e) - (b * d));
		double beans = ((a * e * e) - (a * d * d) - (2 * b * d * e)) / ((b * e * e) - (b * d * d) + (2 * a * d * e));
		Line reflectedLight = new Line(beans, h - beans * k);
		return reflectedLight;
		
	}
	
	public static double radiansToDegrees(double radians) {
		return (radians * 180) / Math.PI;
	}

}
