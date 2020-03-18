package arkanoid;

public class Ball extends Sprite {
	private int radius;
	
	public Ball(int radius, Color color) {
		super(color);
		this.radius = radius;
	}
}
