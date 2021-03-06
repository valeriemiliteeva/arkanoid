package arkanoid.ui;

import arkanoid.Ball;
import arkanoid.Game;
import arkanoid.Screen;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

	private JFrame window;
	private JPanel mainPanel;
	public static final int WIDTH = 503;
	

	public MainWindow(Canvas canvas) {
		// creating object of JFrame(Window popup)
		window = new JFrame();
		// setting closing operation
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setting size of the pop window
		window.setBounds(30, 30, WIDTH, 700);
		window.setResizable(false);
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
		mainPanel.setPreferredSize(new Dimension(WIDTH, 700));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		mainPanel.add(canvas);

		return mainPanel;
	}

	static public void main(String[] args) throws Exception {
		Screen screen = new Screen(Color.WHITE, 650, WIDTH);
		
//		Ball ball = new Ball(7, Color.BLUE);
//		ball.setX(100);
//		ball.setY(100);
//		ball.setSpeed(1250);
//		ball.setAngle(330);
//
//		Ball ball2 = new Ball(7, Color.GREEN);
//		ball2.setX(200);
//		ball2.setY(200);
//		ball2.setSpeed(1250);
//		ball2.setAngle(220);
//
//		Ball ball3 = new Ball(7, Color.PINK);
//		ball3.setX(300);
//		ball3.setY(300);
//		ball3.setSpeed(1250);
//		ball3.setAngle(60);
//
//		Ball ball4 = new Ball(7, Color.YELLOW);
//		ball4.setX(400);
//		ball4.setY(400);
//		ball4.setSpeed(1250);
//		ball4.setAngle(150);
//
//		screen.addSprite(ball);
//		screen.addSprite(ball2);
//		screen.addSprite(ball3);
//		screen.addSprite(ball4);

		Game game = new Game();
		screen.addSprites(game.getBlocks());
		screen.addSprites(game.getBalls());
		screen.addSprite(game.getBoard());

		Canvas canvas = new Canvas(screen);
		MainWindow window = new MainWindow(canvas);
		
		Keyboard keyboard = new Keyboard(game);
		window.window.addKeyListener(keyboard);

		while (true) {
			canvas.repaint();
			Thread.sleep(10);
			screen.animate(10);
			game.play();
		}

	}

}
