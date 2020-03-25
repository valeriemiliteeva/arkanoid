package arkanoid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import util.Point;
import util.Segment;

public class Game {

	private static final Color[] COLORS = { Color.LIGHT_GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA,
			Color.GREEN };
	private static final Color BALL_COLOR = Color.CYAN;
	private static final int BALL_RADIUS = 7;

	private ArrayList<Sprite> blocks = new ArrayList<>();
	private ArrayList<Sprite> balls = new ArrayList<>();
	private HashMap<Ball, Point> ballCenters = new HashMap<>();

	public Game() {
		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 10; i++) {
				Block block = new Block(47, 17, COLORS[j]);
				blocks.add(block);
				block.setX(3 + i * 50);
				block.setY(60 + j * 20);
			}
		}
		Ball ball = new Ball(BALL_RADIUS, BALL_COLOR);
		ball.setX(250);
		ball.setY(620);
		ball.setAngle(45);
		ball.setSpeed(500);
		balls.add(ball);
		saveBallCenters();
	}

	public ArrayList<Sprite> getBlocks() {
		return blocks;
	}

	public ArrayList<Sprite> getBalls() {
		return balls;
	}

	public void play() {
		Ball ball = (Ball) balls.get(0);
		Point oldCenter = ballCenters.get(ball);
		Segment ballSeg = new Segment(oldCenter, new Point(ball.getX(), ball.getY()));
		bounceFromBlocks(ballSeg, ball.getRadius());
		saveBallCenters();
	}

	private void saveBallCenters() {
		for (Sprite sprite : balls) {
			Ball ball = (Ball) sprite;
			ballCenters.put(ball, new Point(ball.getX(), ball.getY()));
		}
	}

	private void bounceFromBlocks(Segment ballSeg, int radius) {
		for (Sprite sprite : blocks) {
			if (!sprite.isVisible()) {
				continue;
			}
			Block block = (Block) sprite;
			for (Segment blockSeg : block.getSegments(radius)) {
				Point intersection = Segment.findIntersection(ballSeg, blockSeg);
				if (intersection == null) {
					continue;
				}
				
				block.setVisible(false);

			}
		}
	}
}
