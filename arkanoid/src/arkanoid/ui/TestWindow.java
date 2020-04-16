package arkanoid.ui;

import java.awt.Color;

import arkanoid.Ball;
import arkanoid.Block;
import arkanoid.Game;
import arkanoid.Screen;
import util.Point;
import util.Segment;

public class TestWindow extends MainWindow {

	public TestWindow(Canvas canvas) {
		super(canvas);
	}

	public static void main(String[] args) throws InterruptedException {
		Screen screen = new Screen(Color.WHITE, 650, WIDTH);
		Block block = new Block(200, 75, Color.PINK);
		block.setX(150);
		block.setY(400);
		
		Ball ball = new Ball(15, Color.CYAN);
		ball.setX(350);
		ball.setY(300);
		ball.setSpeed(150);
		ball.setAngle(120);

		screen.addSprite(block);
		screen.addSprite(ball);

		Canvas canvas = new Canvas(screen);
		TestWindow window = new TestWindow(canvas);
		

		while (true) {
			canvas.repaint();
			Thread.sleep(10);
			Point oldCenter = new Point(ball.getX(), ball.getY());
			screen.animate(10);
			Segment ballSeg = new Segment(oldCenter, new Point(ball.getX(), ball.getY()));
			Game.bounceOffBlockSides(block, ball, ballSeg);
		}
	}

}
