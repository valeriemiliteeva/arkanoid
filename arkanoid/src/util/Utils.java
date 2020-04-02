package util;

import java.util.ArrayList;

public class Utils {

	static public boolean doubleEquals(double a, double b) {
		return Math.abs(a - b) < 1e-6;
	}

	static public boolean doubleGreater(double a, double b) {
		return a - b > -1e-6;
	}

	static public double[] solveQuadraticFormula(double a, double b, double c) {
		if (a == 0) {
			return new double[] { -c / b };
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
	
	public static ArrayList<Point> findCircleAndSegIntersection(Point center, double r, Segment seg, int quadrant) {
		double m = seg.findSlope();
		double b = seg.findYIntercept();
		double c = center.x;
		double d = center.y;
		double[] xVals = solveQuadraticFormula(1 + m * m, 2  * (m * b - m * d - c), c * c + (b - d) * (b - d) - r * r);
		ArrayList<Point> points = new ArrayList<>();
		for (int i = 0; i < xVals.length; i++) {
			Point point = new Point(xVals[i], m * xVals[i] + b);
			if (belongsToQuarterCircle(center, point, quadrant) && Segment.isBetween(seg, point)) {
				points.add(point);
			}
		}
		return points;
	}
	
	public static Line findReflectionEquation(Line line1, Line line2) {
		double a = line1.getA();
		double b = line1.getB();
		double c = line1.getC();
		double d = line2.getA();
		double e = line2.getB();
		double f = line2.getC();
		double h = ((c * d) - (a * f)) / ((b * d) - (a * e));
		double k = ((c * e) - (b * f)) / ((a * e) - (b * d));
		double beans = ((a * e * e) - (a * d * d) - (2 * b * d * e)) / ((b * e * e) - (b * d * d) + (2 * a * d * e));
		Line reflectedLine = new Line(beans, h - beans * k);
		return reflectedLine;
		
	}

}
