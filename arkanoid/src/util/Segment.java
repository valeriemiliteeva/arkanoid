package util;

public class Segment {
	private Point start;
	private Point end;

	public Segment(Point start, Point end) {
		this.start = start;
		this.end = end;
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

	public double findSlope() {
		return (start.y - end.y) / (end.x - start.x);
	}

	public double findYIntercept() {
		return start.y + (start.x * findSlope());
	}

	public static Point findIntersection(Segment s1, Segment s2) {
		/*
		 * method should return intersection point if one exists (otherwise null)
		 */
		double m1 = s1.findSlope();
		double m2 = s2.findSlope();
		double b1 = s1.findYIntercept();
		double b2 = s2.findYIntercept();
		// System.out.println("equation one: y = " + m1 + "x + " + b1 + "; equation two:
		// y = " + m2 + "x + " + b2);
		double xInt = (b2 - b1) / (m2 - m1);
		double yInt = - m1 * xInt + b1;
		if (Math.abs(m1 - m2) < 1e-6) {
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
		if (minX - p.x <= 1e-6 && maxX - p.x >= -1e-6 && minY - p.y <= 1e-6 && maxY - p.y >= -1e-6) {
			return true;
		}
		return false;
	}

}
