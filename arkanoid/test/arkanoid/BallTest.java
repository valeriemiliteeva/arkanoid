package arkanoid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {

  @Test
  void constructor() {
    Color color = new Color();
    Ball ball = new Ball(15, color);
    // assertions
    assertEquals(15, ball.getRadius());
    assertEquals(color, ball.getColor());
  }

}
