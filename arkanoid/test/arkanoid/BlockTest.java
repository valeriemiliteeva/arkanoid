package arkanoid;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.Segment;

class BlockTest {

	private Block block;
	
	@BeforeEach
	void setUp() throws Exception {
		block = new Block(100, 50, Color.PINK);
		block.setX(200);
		block.setY(300);
	}

	@Test
	void getSegments() {
		Segment[] blockSegs = block.getSegments(10);
		assertEquals("(200.00, 290.00) - (300.00, 290.00)", blockSegs[0].toString());
		assertEquals("(310.00, 300.00) - (310.00, 350.00)", blockSegs[1].toString());
		assertEquals("(300.00, 360.00) - (200.00, 360.00)", blockSegs[2].toString());
		assertEquals("(190.00, 350.00) - (190.00, 300.00)", blockSegs[3].toString());
	}

}
