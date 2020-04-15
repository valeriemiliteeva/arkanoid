package arkanoid.ui;

import java.awt.Color;

import arkanoid.Block;
import arkanoid.Screen;

public class TestWindow extends MainWindow {

	public TestWindow(Canvas canvas) {
		super(canvas);
	}

	public static void main(String[] args) throws InterruptedException {
		Screen screen = new Screen(Color.WHITE, 650, WIDTH);
		Block block = new Block(60, 20, Color.PINK);
		block.setX(100);
		block.setY(100);

		screen.addSprite(block);

		Canvas canvas = new Canvas(screen);
		TestWindow window = new TestWindow(canvas);

		while (true) {
			canvas.repaint();
			Thread.sleep(10);
			screen.animate(10);
		}
	}

}
