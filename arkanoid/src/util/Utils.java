package util;

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
	
	public static Point[] findCircleAndSegIntersection(Point center, double r, Segment seg, int quadrant) {
		/*
		 * return only points if they belong to given quadrant\
		 * check that point belongs to given segment
		 */
		double m = seg.findSlope();
		double b = seg.findYIntercept();
		double c = center.x;
		double d = center.y;
		double[] xVals = solveQuadraticFormula(1 + m * m, 2  * (m * b - m * d - c), c * c + (b - d) * (b - d) - r * r);
		Point[] points = new Point[xVals.length];
		for (int i = 0; i < xVals.length; i++) {
			points[i] = new Point(xVals[i], m * xVals[i] + b);
		}
		return points;
	}

}
