package arkanoid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import arkanoid.ui.MainWindow;
import util.Line;
import util.Point;
import util.PointWithQuadrant;
import util.Segment;
import util.Utils;

import static util.Utils.doubleEquals;
import static util.Utils.doubleGreaterOrEqual;

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
//		for (int j = 0; j < 6; j++) {
//			for (int i = 0; i < 10; i++) {
//				Block block = new Block(47, 17, COLORS[j]);
//				blocks.add(block);
//				block.setX(3 + i * 50);
//				block.setY(60 + j * 20);
//			}
//		}
		Ball ball = new Ball(BALL_RADIUS, BALL_COLOR);
		balls.add(ball);
		resetBall();

		board = new Board(90, 15, Color.LIGHT_GRAY);
		resetBoard();
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
		// bounceOffBoard(ballSeg, ball);
		// restrainBoard();
		saveBallCenters();
	}

	public void resetBall() {
		Ball ball = (Ball) balls.get(0);
		ball.setX(250);
		ball.setY(20);
		ball.setAngle(45);
		ball.setSpeed(INITIAL_SPEED);
		saveBallCenters();
	}

	public void resetBoard() {
		board.setX(205);
		board.setY(630);
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

			Block block = (Block) sprite;
			if (bounceOffBlockSides(block, ball, ballSeg)) {
				return;
			}
		}

		for (Sprite sprite : blocks) {
			if (!sprite.isVisible()) {
				continue;
			}

			Block block = (Block) sprite;
			if (bounceOffBlockCorners(block, ball, ballSeg)) {
				return;
			}
		}
	}

	public static void bounceOffBlock(Segment blockSide, Ball ball) {
		if (doubleEquals(blockSide.getStart().y, blockSide.getEnd().y)) {
			if (doubleGreaterOrEqual(ball.y, blockSide.getStart().y)) {
				ball.bounceUp(blockSide.getStart().y);
			} else {
				ball.bounceDown(blockSide.getStart().y);
			}
		}
		if (doubleEquals(blockSide.getStart().x, blockSide.getEnd().x)) {
			if (doubleGreaterOrEqual(ball.x, blockSide.getStart().x)) {
				ball.bounceLeft(blockSide.getStart().x);
			} else {
				ball.bounceRight(blockSide.getStart().x);
			}
		}
	}

	public static boolean bounceOffBlockSides(Block block, Ball ball, Segment ballSeg) {
		Point oldCenter = ballSeg.getStart();
		Point intersectionPoint = null;
		double distanceFromOldCenter = Double.MAX_VALUE;
		Segment hitSegment = null;
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
			/*
			 * making the ball stay where it hit the block, only changing the angle, not the
			 * location
			 */
			ball.setX(intersectionPoint.x);
			ball.setY(intersectionPoint.y);
			ball.move(0.0001, 99999, 99999);
			// hide block
			block.setVisible(false);
			return true;
		}
		return false;
	}

	public static boolean bounceOffBlockCorners(Block block, Ball ball, Segment ballSeg) {
		ArrayList<PointWithQuadrant> points = new ArrayList<>();

		for (int quadrant = 1; quadrant <= 4; quadrant++) {
			points.addAll(
					Utils.findCircleAndSegIntersection(block.getCorner(quadrant), ball.getRadius(), ballSeg, quadrant));
		}
		PointWithQuadrant intersectionPoint = Utils.findClosestPoint(ballSeg.getStart(), points);
		if (intersectionPoint == null) {
			return false;
		}
		Point cornerPoint = block.getCorner(intersectionPoint.getQuadrant());
		Line cornerLine = new Line(intersectionPoint, cornerPoint);
		double m = cornerLine.getSlope();
		double reciprocal = Utils.doubleDivide(1, m);
		Line tangentLine = new Line(- reciprocal, intersectionPoint.y + reciprocal * intersectionPoint.x);
		Line lightLine = new Line(ballSeg.getStart(), ballSeg.getEnd());
		Line reflectedLine = Utils.findReflectionEquation(lightLine, tangentLine);

		/*
		 * find second point on the reflected line which is in the direction the ball
		 * will go next if this point is higher than the intersectionPoint then angle is
		 * less than 180 otherwise it is greater than 180
		 */
		ball.setX(intersectionPoint.x);
		ball.setY(intersectionPoint.y);
		ball.setAngle(findAngle(cornerPoint, ball, reflectedLine));
		ball.move(.01, 99999, 99999);
		return true;

	}

	private static int findAngle(Point cornerPoint, Ball ball, Line reflectedLine) {
		Point pLeft = new Point(ball.x - 0.001, reflectedLine.calculateY(ball.x - 0.001));
		Point pRight = new Point(ball.x + 0.001, reflectedLine.calculateY(ball.x + 0.001));
		double leftDistance = Point.findDistance(pLeft, cornerPoint);
		double rightDistance = Point.findDistance(pRight, cornerPoint);
		Point outsidePoint = null;
		if (leftDistance > ball.getRadius()) {
			outsidePoint = pLeft;
		}
		if (rightDistance > ball.getRadius()) {
			if (outsidePoint != null) {
				return ball.getAngle();
				/*
				 * ensures the angle of the ball doesn't actually change because it didn't
				 * actually hit the block, so we do not reflect
				 */
			}
			outsidePoint = pRight;
		}
		if (outsidePoint == null) {
			System.out.println("wack 1");
		}
		double angle = Utils.radiansToDegrees(Math.atan(reflectedLine.getSlope()));
		if (outsidePoint.x > ball.x && outsidePoint.y < ball.y) {
			if (angle > 0) {
				System.out.println("wack 2");
			} else {
				angle = angle + 360;
			}
		} else if (outsidePoint.x > ball.x && outsidePoint.y > ball.y) {
			if (angle < 0) {
				System.out.println("wack 3");
			}
		} else if (outsidePoint.x < ball.x && outsidePoint.y > ball.y) {
			if (angle > 0) {
				System.out.println("wack 4");
			}
			angle = angle + 180;
		} else if (outsidePoint.x < ball.x && outsidePoint.y < ball.y) {
			if (angle < 0) {
				System.out.println("wack 5");
			}
			angle = angle + 180;
		}
		return (int) Math.round(angle);
	}

	private void bounceOffBoard(Segment segment, Ball ball) {
		if (Segment.findIntersection(segment, board.getTopMidSeg()) != null) {
			ball.bounceUp(board.getY() - 4);
		} else if (Segment.findIntersection(segment, board.getTopRightSeg()) != null) {
			ball.setAngle(ball.getAngle());
		} else if (Segment.findIntersection(segment, board.getTopLeftSeg()) != null) {
			// wot r u doin
		}
	}

	public void restrainBoard() {
		if (board.getX() < 0) {
			board.setX(0);
		} else if (board.getX() > MainWindow.WIDTH - board.getLength()) {
			board.setX(MainWindow.WIDTH - board.getLength());
		}
	}

}
