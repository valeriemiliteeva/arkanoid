package arkanoid;

public class Sprite {
	private Color color;
	int x;
	/**
	 * location of sprite (x,y)
	 */
	int y;
	/**
	 * pixels per second
	 */
	private int speed;
	/**
	 * calculated from 0 to 359
	 */
	int angle;

	public Sprite(Color color) {
		this.color = color;
	}

	protected double angleInRadians() {
		return (angle * Math.PI) / 180;
	}

	private void draw(Screen screen) {
		// implement draw method
	}

	public Color getColor() {
		return color;
	}

	private static int round(double d) {
		return (int)Math.round(d);
	}
	
	public void bounce(int maxX, int maxY) {

	}

	public void move(int pixels, int maxX, int maxY) {
		int dx;
		int dy;
		if (angle < 90) {
			dx = round(pixels / Math.sqrt((1 + Math.pow(Math.tan(angleInRadians()), 2))));
			dy = -round(dx * (Math.tan(angleInRadians())));
		} else if (angle == 90) {
			dx = 0;
			dy = -pixels;
		} else if (angle < 180) {
			double angle2 = Math.PI - angleInRadians();
			dx = -round(pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2))));
			dy = -round(-dx * (Math.tan(angle2)));
		} else if (angle == 180) {
			dx = -pixels;
			dy = 0;
		} else if (angle < 270) {
			double angle2 = angleInRadians() - Math.PI;
			dx = -round(pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2))));
			dy = round(-dx * (Math.tan(angle2)));
		} else if (angle == 270) {
			dx = 0;
			dy = pixels;
		} else {
			double angle2 = 2 * Math.PI - angleInRadians();
			dx = round(pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2))));
			dy = round(dx * (Math.tan(angle2)));
		}
		x += dx;
		y += dy;
		
		bounce(maxX, maxY);
	}

}
