package arkanoid.ui;

import arkanoid.Screen;
import arkanoid.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Canvas extends JComponent {

  private Random random = new Random();

  private Screen screen;

  public Canvas(Screen screen) {
    this.screen = screen;
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setBackground(Color.DARK_GRAY);
    g2d.clearRect(0, 0, screen.getWidth(), screen.getHeight());
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    for (Sprite sprite: screen.getSprites()) {
      if (sprite.isVisible()) {
    	  sprite.draw(g2d, screen.getHeight());
      }
    }
  }

}
