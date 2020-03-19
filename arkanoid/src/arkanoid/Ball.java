package arkanoid;

public class Ball extends Sprite {
	private int radius;

	public int getRadius() {
		return radius;
	}

	public Ball(int radius, Color color) {
		super(color);
		this.radius = radius;
	}

	@Override
	public void bounce(int maxX, int maxY) {
		if (x > maxX - radius) {
			if (angle < 90) {
				angle = 180 - angle;
			} else if (angle > 270) {
				angle = 540 - angle;
			} else if (angle == 0) {
				//beans
			}
			x = 2 * maxX - 2 * radius - x;
		}

		if (y > maxY - radius) {
			if (angle < 270) {
				angle = 360 - angle;
			} else if (angle > 270) {
				angle = 360 - angle;
			} else if (angle == 270) {
				//beans
			}
			y = 2 * maxY - 2 * radius - y;
		}

		if (x < radius) {
			if (angle < 180) {
				angle = 180 - angle;
			} else if (angle > 180) {
				angle = 540 - angle;
			} else if (angle == 180) {
				//beans
			}
			x = 2 * radius  - x;
		}

		if (y < radius) {
			if (angle < 90) {
				angle = 360 - angle;
			} else if ( angle > 90) {
				angle = 360 - angle;
			} else if (angle == 90) {
				//beans
			}
			y = 2 * radius - y;
		}
	}
}
