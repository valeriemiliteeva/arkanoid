package arkanoid;

import java.util.ArrayList;

public class Screen {
	private int height;
	private int width;
	private Color color;
	/**
	 * creates a list that stores all sprites on the screen
	 */
	private ArrayList<Sprite> sprites;

	public Screen(Color color, int height, int width) {
		this.color = color;
		this.height = height;
		this.width = width;
	}

	private void sleep() {
		// delays method (Timer class)
	}

	private void makeAlive() {
		// animates object and starts movement
	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
	}

	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}
	
}
