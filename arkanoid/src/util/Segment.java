package util;

public class Segment {
	private Point start;
	private Point end;

	public Segment(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public String toString() {
		return String.format("%s - %s", start, end);
	}

	public static Point findIntersection(Segment s1, Segment s2) {
		/*
		 * method should return intersection point if one exists (otherwise null)
		 */
		double m1 = (s1.end.y - s1.start.y) / (s1.end.x - s1.start.x);
		double m2 = (s2.end.y - s2.start.y) / (s2.end.x - s2.start.x);
		double b1 = s1.start.y - (s1.start.x * m1);
		double b2 = s2.start.y - (s2.start.x * m2);
		//System.out.println("equation one: y = " + m1 + "x + " + b1 + "; equation two: y = " + m2 + "x + " + b2);
		double xInt = -(b1 - b2) / (m1 - m2);
		double yInt = m1 * xInt + b1;
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
	
	private static boolean isBetween(Segment s, Point p) {
		double minX = Math.min(s.start.x, s.end.x);
		double maxX = Math.max(s.start.x, s.end.x);
		double minY = Math.min(s.start.y, s.end.y);
		double maxY = Math.max(s.start.y, s.end.y);
		if (minX <= p.x && maxX >= p.x && minY <= p.y && maxY >= p.y) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		Point st1 = new Point(6.0, 4.0);
		Point end1 = new Point(4.0, 8.0);
		Point end2 = new Point(6.0, 3.0);
		Point st2 = new Point(0.0, 9.0);
		Segment s1 = new Segment(st1, end1);
		Segment s2 = new Segment(st2, end2);
		Point iPoint = findIntersection(s1, s2);
		if (iPoint != null) {
			System.out.println("Intersection point: (" + iPoint.x + ", " + iPoint.y + ")");
		} else {
			System.out.println("Segments do not intersect");
		}
	}

}
