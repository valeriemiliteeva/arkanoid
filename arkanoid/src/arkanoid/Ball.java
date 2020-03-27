package arkanoid;

import java.awt.*;

public class Ball extends Sprite {
	private int radius;

	public Ball(int radius, Color color) {
		super(color);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(getColor());
		g.fillOval(round(x - radius), round(y - radius), round(radius * 2), round(radius * 2));
	}

	public void bounceLeft(double wallX) {
		if (x > wallX - radius) {
			if (angle < 90) {
				angle = 180 - angle;
			} else if (angle > 270) {
				angle = 540 - angle;
			} else if (angle == 0) {
				angle = 90;
			}
			x = 2 * wallX - 2 * radius - x;
		}
	}

	public void bounceUp(double wallY) {
		if (y > wallY - radius) {
			if (angle < 270) {
				angle = 360 - angle;
			} else if (angle > 270) {
				angle = 360 - angle;
			} else if (angle == 270) {
				angle = 90;
			}
			y = 2 * wallY - 2 * radius - y;
		}
	}

	public void bounceRight(double wallX) {
		if (x < wallX + radius) {
			if (angle < 180) {
				angle = 180 - angle;
			} else if (angle > 180) {
				angle = 540 - angle;
			} else if (angle == 180) {
				angle = 0;
			}
			x = 2 * wallX + 2 * radius - x;
		}
	}

	public void bounceDown(double wallY) {
		if (y < wallY + radius) {
			if (angle < 90) {
				angle = 360 - angle;
			} else if (angle > 90) {
				angle = 360 - angle;
			} else if (angle == 90) {
				angle = 270;
			}
			y = 2 * wallY + 2 * radius - y;
		}
	}

	@Override
	public void bounce(int maxX, int maxY) {
		bounceLeft(maxX);
		bounceRight(0);
		bounceDown(0);

	}
}
