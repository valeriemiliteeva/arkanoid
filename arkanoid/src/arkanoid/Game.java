package arkanoid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import arkanoid.ui.MainWindow;
import util.Point;
import util.Segment;

import static util.Utils.doubleEquals;
import static util.Utils.doubleGreater;

public class Game {

	private static final int INITIAL_SPEED = 600;

	private static final Color[] COLORS = { Color.LIGHT_GRAY, Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA,
			Color.GREEN };
	private static final Color BALL_COLOR = Color.CYAN;
	private static final int BALL_RADIUS = 7;

	private ArrayList<Sprite> blocks = new ArrayList<>();
	private ArrayList<Sprite> balls = new ArrayList<>();
	private Board board;
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
		ball.setSpeed(INITIAL_SPEED);
		balls.add(ball);
		saveBallCenters();
		
		board = new Board(90, 15, Color.LIGHT_GRAY);
		board.setX(205);
		board.setY(630);
	}

	public ArrayList<Sprite> getBlocks() {
		return blocks;
	}

	public ArrayList<Sprite> getBalls() {
		return balls;
	}
	
	public Board getBoard() {
		return board;
	}

	public void play() {
		Ball ball = (Ball) balls.get(0);
		Point oldCenter = ballCenters.get(ball);
		Segment ballSeg = new Segment(oldCenter, new Point(ball.getX(), ball.getY()));
		bounceFromBlocks(ballSeg, ball);
		saveBallCenters();
	}

	private void saveBallCenters() {
		for (Sprite sprite : balls) {
			Ball ball = (Ball) sprite;
			ballCenters.put(ball, new Point(ball.getX(), ball.getY()));
		}
	}

	private void bounceFromBlocks(Segment ballSeg, Ball ball) {
		for (Sprite sprite : blocks) {
			if (!sprite.isVisible()) {
				continue;
			}
			Point oldCenter = ballSeg.getStart();
			Point intersectionPoint = null;
			double distanceFromOldCenter = Double.MAX_VALUE;
			Segment hitSegment = null;

			Block block = (Block) sprite;
			for (Segment blockSeg : block.getSegments(ball.getRadius())) {
				Point newIntersection = Segment.findIntersection(ballSeg, blockSeg);
				if (newIntersection == null) {
					continue;
				}
				double newDistanceFromOldCenter = Point.findDistance(oldCenter, newIntersection);
				if (newDistanceFromOldCenter < distanceFromOldCenter) {
					intersectionPoint = newIntersection;
					distanceFromOldCenter = newDistanceFromOldCenter;
					hitSegment = blockSeg;
				}
			}
			// intersectionPoint now is the closest intersection from old center
			if (intersectionPoint != null) {
				// ball hit the block!
				// bounce off of it
				bounceOffBlock(hitSegment, ball);
				// hide block
				block.setVisible(false);
			}
		}
	}

	private void bounceOffBlock(Segment segment, Ball ball) {
		if (doubleEquals(segment.getStart().y, segment.getEnd().y)) {
			if (doubleGreater(ball.y, segment.getStart().y)) {
				ball.bounceUp(segment.getStart().y);
			} else {
				ball.bounceDown(segment.getStart().y);
			}
		}
		if (doubleEquals(segment.getStart().x, segment.getEnd().x)) {
			if (doubleGreater(ball.x, segment.getStart().x)) {
				ball.bounceLeft(segment.getStart().x);
			} else {
				ball.bounceRight(segment.getStart().x);
			}
		}
	}
	
	private void bounceOffBoard(Segment segment, Ball ball) {
		/* 
		 * check if segment intersects top of board
		 * bounceUp() -- pass board.getY()
		 * 
		 */
	}

	public void moveBoard(int distance) {
		board.setX(board.getX() + distance);
		if (board.getX() < 0) {
			board.setX(0);
		} else if (board.getX() > MainWindow.WIDTH - board.getLength()) {
			board.setX(MainWindow.WIDTH - board.getLength());
		}
	}

}
