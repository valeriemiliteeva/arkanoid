package util;

public class PointWithQuadrant extends Point {

	private int quadrant;

	public PointWithQuadrant(double x, double y, int quadrant) {
		super(x, y);
		this.quadrant = quadrant;
	}

	public int getQuadrant() {
		return quadrant;
	}

}
