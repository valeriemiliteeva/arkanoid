package arkanoid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import util.Point;
import util.Segment;

public class SegmentTest {

	@Test
	public void findIntersection() {
		Point st1 = new Point(6.0, 4.0);
		Point end1 = new Point(4.0, 8.0);
		Point end2 = new Point(6.0, 3.0);
		Point st2 = new Point(0.0, 9.0);
		Segment s1 = new Segment(st1, end1);
		Segment s2 = new Segment(st2, end2);
		Point iPoint = Segment.findIntersection(s1, s2);
		assertNull(iPoint);
	}
	
	@Test
	public void findIntersection2() {
		Point st1 = new Point(2.0, 2.0);
		Point end1 = new Point(5.0, 4.0);
		Point end2 = new Point(4.0, 0.0);
		Point st2 = new Point(3.0, 5.0);
		Segment s1 = new Segment(st1, end1);
		Segment s2 = new Segment(st2, end2);
		Point iPoint = Segment.findIntersection(s1, s2);
		assertEquals(3.41, iPoint.x, 1e-2);
		assertEquals(2.94, iPoint.y, 1e-2);
	}
	
	@Test
	public void findIntersection3() {
		Point st1 = new Point(2.0, 2.0);
		Point end1 = new Point(5.0, 4.0);
		Point end2 = new Point(4.0, 0.0);
		Point st2 = new Point(3.0, 2.0);
		Segment s1 = new Segment(st1, end1);
		Segment s2 = new Segment(st2, end2);
		Point iPoint = Segment.findIntersection(s1, s2);
		assertNull(iPoint);
	}
	
	@Test
	public void findIntersection4() {
		Point st1 = new Point(2.0, 2.0);
		Point end1 = new Point(3.0, 3.0);
		Point end2 = new Point(1.0, 1.0);
		Point st2 = new Point(4.0, 4.0);
		Segment s1 = new Segment(st1, end1);
		Segment s2 = new Segment(st2, end2);
		Point iPoint = Segment.findIntersection(s1, s2);
		assertNull(iPoint);
	}

	@Test
	public void findIntersection5() {
		Point st1 = new Point(2.0, 2.0);
		Point end1 = new Point(3.0, 3.0);
		Point end2 = new Point(1.0, 0.0);
		Point st2 = new Point(4.0, 3.0);
		Segment s1 = new Segment(st1, end1);
		Segment s2 = new Segment(st2, end2);
		Point iPoint = Segment.findIntersection(s1, s2);
		assertNull(iPoint);
	}
}
