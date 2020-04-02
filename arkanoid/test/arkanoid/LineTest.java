package arkanoid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import util.Line;
import util.Utils;

public class LineTest {

	@Test
	public void findReflectionEquation1() {
		Line line1 = new Line(1, 0);
		Line reflection = new Line(0, 0);
		Line result = Utils.findReflectionEquation(line1, reflection);
		System.out.println(result);
		assertEquals("y = -1.00 * x + 0.00", result.toString());
	}
	
	@Test
	public void findReflectionEquation2() {
		Line line1 = new Line(1, 2);
		Line reflection = new Line(0, -2);
		Line result = Utils.findReflectionEquation(line1, reflection);
		System.out.println(result);
		assertEquals("y = -1.00 * x + -6.00", result.toString());
	}
	
	/*
	 * write more tests with more complex angles (0 - 90)
	 */
}
