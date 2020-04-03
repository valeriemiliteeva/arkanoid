package arkanoid;

import java.awt.Color;
import java.awt.Graphics2D;

import util.Point;
import util.Segment;

public class Block extends Sprite {

	private int width;
	private int height;

	public Block(int width, int height, Color color) {
		super(color);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());
		g.fillRect(round(x), round(y), width, height);
	}

	public Segment[] getSegments(int pixelsFrom) {
//		Point topLeft = new Point(getX(), getY());
//		Point topRight = new Point(getX() + width, getY());
//		Point bottomRight = new Point(getX() + width, getY() + height);
//		Point bottomLeft = new Point(getX(), getY() + height);
		Segment top = new Segment(new Point(getX(), getY() - pixelsFrom),
				new Point(getX() + width, getY() - pixelsFrom));
		Segment right = new Segment(new Point(getX() + width + pixelsFrom, getY()),
				new Point(getX() + width + pixelsFrom, getY() + height));
		Segment bottom = new Segment(new Point(getX() + width, getY() + height + pixelsFrom),
				new Point(getX(), getY() + height + pixelsFrom));
		Segment left = new Segment(new Point(getX() - pixelsFrom, getY() + height),
				new Point(getX() - pixelsFrom, getY()));
		return new Segment[] { top, right, bottom, left };
	}

	public Point getCorner(int quadrant) {
		if (quadrant == 1) {
			return new Point(x, y);
		} else if (quadrant == 2) {
			return new Point(x + width, y);
		} else if (quadrant == 3) {
			return new Point(x + width, y + height);
		} else if (quadrant == 4) {
			return new Point(x, y + height);
		}
		throw new RuntimeException("no");
	}

}
