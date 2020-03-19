package arkanoid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpriteTest {

	private Sprite sprite;

	@BeforeEach
	void setUp() {
		sprite = new Sprite(new Color());
		sprite.x = 100;
		sprite.y = 100;
	}

	@Test
	void moveAngleUnder90() {
		sprite.angle = 30;
		sprite.move(12);
		assertEquals(110, sprite.x);
		assertEquals(94, sprite.y);
	}

	@Test
	void moveAngle90() {
		sprite.angle = 90;
		sprite.move(20);
		assertEquals(100, sprite.x);
		assertEquals(80, sprite.y);
	}

	@Test
	void moveAngleUnder180() {
		sprite.angle = 120;
		sprite.move(12);
		assertEquals(94, sprite.x);
		assertEquals(90, sprite.y);
	}

	@Test
	void moveAngle180() {
		sprite.angle = 180;
		sprite.move(20);
		assertEquals(80, sprite.x);
		assertEquals(100, sprite.y);
	}

	@Test
	void moveAngleUnder270() {
		sprite.angle = 240;
		sprite.move(12);
		assertEquals(94, sprite.x);
		assertEquals(110, sprite.y);
	}

	@Test
	void moveAngle270() {
		sprite.angle = 270;
		sprite.move(8);
		assertEquals(100, sprite.x);
	 	assertEquals(108, sprite.y);
	}

	@Test
	void moveAngleUnder360() {
		sprite.angle = 300;
		sprite.move(12);
		assertEquals(106, sprite.x);
		assertEquals(110, sprite.y);
	}

}
