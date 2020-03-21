package arkanoid;

import java.awt.*;

abstract public class Sprite {
	private Color color;

  protected double x;
	/**
	 * location of sprite (x,y)
	 */
  protected double y;
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

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getAngle() {
    return angle;
  }

  public void setAngle(int angle) {
    this.angle = angle;
  }

  protected double angleInRadians() {
		return (angle * Math.PI) / 180;
	}

	abstract public void draw(Graphics2D g);

	public Color getColor() {
		return color;
	}

	public static int round(double d) {
		return (int)Math.round(d);
	}
	
	public void bounce(int maxX, int maxY) {

	}

	public void move(double pixels, int maxX, int maxY) {
		double dx;
		double dy;
		if (angle < 90) {
			dx = pixels / Math.sqrt((1 + Math.pow(Math.tan(angleInRadians()), 2)));
			dy = - dx * (Math.tan(angleInRadians()));
		} else if (angle == 90) {
			dx = 0;
			dy = -pixels;
		} else if (angle < 180) {
			double angle2 = Math.PI - angleInRadians();
			dx = -pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2)));
			dy = dx * (Math.tan(angle2));
		} else if (angle == 180) {
			dx = -pixels;
			dy = 0;
		} else if (angle < 270) {
			double angle2 = angleInRadians() - Math.PI;
			dx = -pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2)));
			dy = -dx * (Math.tan(angle2));
		} else if (angle == 270) {
			dx = 0;
			dy = pixels;
		} else {
			double angle2 = 2 * Math.PI - angleInRadians();
			dx = pixels / Math.sqrt((1 + Math.pow(Math.tan(angle2), 2)));
			dy = dx * (Math.tan(angle2));
		}
		x += dx;
		y += dy;
		
		bounce(maxX, maxY);
	}

}
