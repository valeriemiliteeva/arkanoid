package arkanoid;

import java.awt.*;
import java.util.ArrayList;

public class Screen {
	private int height;
	private int width;
	private Color color;

	/**
	 * creates a list that stores all sprites on the screen
	 */
	private ArrayList<Sprite> sprites = new ArrayList<>();

	public Screen(Color color, int height, int width) {
		this.color = color;
		this.height = height;
		this.width = width;
	}

	private void sleep() {
		// delays method (Timer class)
	}

	public void animate(int millis) {
		for (Sprite sprite: sprites) {
			sprite.move(sprite.getSpeed() * millis / 1000.0, width, height);
		}
	}

	public void addSprite(Sprite sprite) {
		sprites.add(sprite);
	}

	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}

	public ArrayList<Sprite> getSprites() {
		return sprites;
	}

}
