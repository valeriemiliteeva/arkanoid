package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Sprite {
	
	private int width;
	private int height;
	

	public Block (int width, int height, Color color) {
		super(color);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());
		g.fillRect(round(x), round(y), width, height);
	}
	
}
