package arkanoid;

public class Sprite {
	private Color color;
	private int x;
	/**
	 * location of sprite (x,y)
	 */
	private int y;
	/**
	 * pixels per second
	 */
	private int speed;
	/**
	 * calculated from 0 to 359
	 */
	private int angle;

	public Sprite(Color color) {
		this.color = color;
	}

	protected double angleInRadians() {
		return (angle * Math.PI) / 180;
	}

	private void draw(Screen screen) {
		// implement draw method
	}

	private void move(int pixels) {
		int dx;
		int dy;
		if (angle < 90) {
			dx = (int) (pixels / Math.sqrt((1 + Math.pow(Math.tan(angleInRadians()), 2))));
			dy = -(int) (dx * (Math.tan(angleInRadians())));
		} else if (angle == 90) {
			dx = 0;
			dy = -pixels;
		} else if (angle < 180) {
			double angle2 = Math.PI - angleInRadians();
			dx = -(int) (pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2))));
			dy = -(int) (dx * (Math.tan(angle2)));
		} else if (angle == 180) {
			dx = -pixels;
			dy = 0;
		} else if (angle < 270) {
			double angle2 = angleInRadians() - Math.PI;
			dx = -(int) (pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2))));
			dy = (int) (dx * (Math.tan(angle2)));
		} else if (angle == 270) {
			dx = 0;
			dy = pixels;
		} else {
			double angle2 = 2 * Math.PI - angleInRadians();
			dx = (int) (pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2))));
			dy = (int) (dx * (Math.tan(angle2)));
		}
		x += dx;
		y += dy;
	}

}
