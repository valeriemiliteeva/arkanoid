package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;

public class Board extends Sprite {
	protected int length;
	protected int height;
	
	public Board(int length, int height, Color color) {
		super(color);
		this.height = height;
		this.length = length;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());
		g.fillRect(round(x), round(y), length, height);
		g.setColor(Color.PINK);
		g.drawRect(round(x), round(y), length, height);
		
	}
	
	
}
