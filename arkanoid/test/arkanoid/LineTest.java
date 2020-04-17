package arkanoid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import util.Line;
import util.Utils;

public class LineTest {

	@Test
	public void findReflectionEquation1() {
		Line light = new Line(1, 0);
		Line wall = new Line(0, 0);
		Line result = Utils.findReflectionEquation(light, wall);
		System.out.println(result);
		assertEquals("y = -1.00 * x + 0.00", result.toString());
	}
	
	@Test
	public void findReflectionEquation2() {
		Line light = new Line(1, 2);
		Line wall = new Line(0, -2);
		Line result = Utils.findReflectionEquation(light, wall);
		System.out.println(result);
		assertEquals("y = -1.00 * x + -6.00", result.toString());
	}
	
	@Test
	public void findReflectionEquation3() {
		Line light = new Line(-3, 4);
		Line wall = new Line(-1, 1);
		Line result = Utils.findReflectionEquation(light, wall);
		System.out.println(result);
		assertEquals("y = -0.33 * x + 0.00", result.toString());
	}
	
	@Test
	public void findReflectionEquation4() {
		Line light = new Line(-0.5, 4);
		Line wall = new Line(-3, -1);
		Line result = Utils.findReflectionEquation(light, wall);
		System.out.println(result);
		assertEquals("y = 2.00 * x + 9.00", result.toString());
	}
	
	@Test
	public void findReflectionEquation5() {
		Line light = new Line(-1.5, 0);
		Line wall = new Line(-3, -4);
		Line result = Utils.findReflectionEquation(light, wall);
		System.out.println(result);
		assertEquals("y = 2.00 * x + 9.00", result.toString());
	}
	/*
	 * write more tests with more complex angles (0 - 90)
	 */
}
