package arkanoid.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Canvas extends JComponent {

  int centerX = 100, centerY = 100;
  int radius = 7;

  Random random = new Random();

  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D)g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    g.setColor(Color.BLUE);
    g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
//    centerX += random.nextInt(7) - 3;
//    centerY += random.nextInt(7) - 3;
    centerX += 3;
    centerY += 2;
  }

}
