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
    assertEquals(95, sprite.y);
  }

  @Test
  void moveAngle90() {
    sprite.angle = 90;
    sprite.move(20);
    assertEquals(100, sprite.x);
    assertEquals(80, sprite.y);
  }

}