package arkanoid.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

  private JFrame window;
  private JPanel mainPanel;

  public MainWindow(Canvas canvas) {
    // creating object of JFrame(Window popup)
    window = new JFrame();
    // setting closing operation
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // setting size of the pop window
    window.setBounds(30, 30, 1000, 500);
    // setting canvas for draw
    initPanels(canvas);
    window.getContentPane().add(mainPanel);
    // set visibility
    window.pack();
    window.setVisible(true);
    //
  }

  private JPanel initPanels(Canvas canvas) {
    mainPanel = new JPanel();
    mainPanel.setPreferredSize(new Dimension(1000, 500));
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    mainPanel.add(canvas);

    return mainPanel;
  }

  static public void main(String[] args) throws Exception {
    Canvas canvas = new Canvas();
    MainWindow window = new MainWindow(canvas);

    while (true) {
      canvas.repaint();
      window.mainPanel.repaint();
      Thread.sleep(10);
    }

  }

}
