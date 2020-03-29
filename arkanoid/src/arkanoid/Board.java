package arkanoid;

import java.awt.BasicStroke;
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

	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());
		g.fillRect(round(x), round(y), length, height);
		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(4));
		g.drawRect(round(x), round(y), length, height);
		
	}
	
}
