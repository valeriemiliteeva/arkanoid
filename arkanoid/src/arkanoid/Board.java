package arkanoid;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import util.Point;
import util.Segment;

public class Board extends Sprite {
	protected int length;
	protected int height; 
	private static final int SIDE_LENGTH = 10;
	
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
	public void draw(Graphics2D g, int screenHeight) {
		g.setColor(getColor());
		g.fillRect(round(x) + SIDE_LENGTH, screenHeight - round(y), length - 2 * SIDE_LENGTH, height);
		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(4));
		g.drawRect(round(x) + SIDE_LENGTH, screenHeight - round(y), length - 2 * SIDE_LENGTH, height);
		g.setColor(Color.PINK);
		g.fillRect(round(x), screenHeight - round(y) - 2, SIDE_LENGTH, height + 4);
		g.fillRect(round(x) + length - 10, screenHeight - round(y) - 2, SIDE_LENGTH, height + 4);
		g.setColor(Color.RED);
		g.drawRect(round(x), screenHeight - round(y) - 2, SIDE_LENGTH, height + 4);
		g.drawRect(round(x) + length - SIDE_LENGTH, screenHeight - round(y) - 2, SIDE_LENGTH, height + 4);		
		
	}
	
	public Segment getTopMidSeg() {
		return new Segment(new Point(x + SIDE_LENGTH, y + 4), new Point(x - 2 * SIDE_LENGTH + length, y + 4));
	}
	
	public Segment getTopLeftSeg() {
		return new Segment(new Point(x, y + 4), new Point(x + SIDE_LENGTH, y + 4));
	}
	
	public Segment getTopRightSeg() {
		return new Segment(new Point(x + length - SIDE_LENGTH, y + 4), new Point(x + length, y + 4));
	}
	
	
	
	
}
