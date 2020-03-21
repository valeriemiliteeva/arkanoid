package arkanoid;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {

  @Test
  void constructor() {
    Ball ball = new Ball(15, Color.BLUE);
    // assertions
    assertEquals(15, ball.getRadius());
    assertEquals(Color.BLUE, ball.getColor());
  }

}
