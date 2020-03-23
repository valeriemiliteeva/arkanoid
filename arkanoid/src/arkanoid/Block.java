package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Point;
import util.Segment;

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
	
	public Segment[] getSegments() {
		Point topLeft = new Point(getX(), getY());
		Point topRight = new Point(getX() + width, getY());
		Point bottomRight = new Point(getX() + width, getY() + height);
		Point bottomLeft = new Point(getX(), getY() + height);
		Segment top = new Segment(topLeft, topRight);
		Segment right = new Segment(topRight, bottomRight);
		Segment bottom = new Segment(bottomLeft, bottomRight);
		Segment left = new Segment(bottomLeft, topLeft);
		return new Segment[] {top, right, bottom, left};
	}
	
}
