package util;

public class Segment extends Line {
	private Point start;
	private Point end;

	public Segment(Point start, Point end) {
		super(start, end);
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public String toString() {
		return String.format("%s - %s", start, end);
	}

	public static double findSlope(Point start, Point end) {
		return Utils.doubleDivide(start.y - end.y, end.x - start.x);
	}

	public static double findYIntercept(Point start, double slope) {
		return start.y + (start.x * slope);
	}

	public static Point findIntersection(Segment s1, Segment s2) {
		/*
		 * method should return intersection point if one exists (otherwise null)
		 */
		double m1 = s1.slope;
		double m2 = s2.slope;
		double b1 = s1.yInt;
		double b2 = s2.yInt;
		// System.out.println("equation one: y = " + m1 + "x + " + b1 + "; equation two:
		// y = " + m2 + "x + " + b2);
		double xInt = Utils.doubleDivide(b2 - b1, m1 - m2);
		double yInt = m1 * xInt + b1;
		if (Utils.doubleEquals(m1, m2)) {
			return null;
		} else {
			Point iPoint = new Point(xInt, yInt);
			if (isBetween(s1, iPoint) && isBetween(s2, iPoint)) {
				return iPoint;
			} else {
				return null;
			}
		}
	}

	public static boolean isBetween(Segment s, Point p) {
		double minX = Math.min(s.start.x, s.end.x);
		double maxX = Math.max(s.start.x, s.end.x);
		double minY = Math.min(s.start.y, s.end.y);
		double maxY = Math.max(s.start.y, s.end.y);
		if (Utils.doubleGreater(p.x, minX) && Utils.doubleGreater(maxX, p.x) && 
				Utils.doubleGreater(p.y, minY) && Utils.doubleGreater(maxY, p.y)) {
			return true;
		}
		return false;
	}

}
