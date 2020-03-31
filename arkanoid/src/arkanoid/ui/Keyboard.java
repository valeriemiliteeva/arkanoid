package arkanoid.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import arkanoid.Board;
import arkanoid.Game;

public class Keyboard extends KeyAdapter {

	public static final int LEFT = 37;
	public static final int RIGHT = 39;
	private Game game;

	public Keyboard(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 37) {
			game.getBoard().setSpeed(400);
			game.getBoard().setAngle(180);
		} else if (e.getKeyCode() == 39) {
			game.getBoard().setSpeed(400);
			game.getBoard().setAngle(0);
		} else if (e.getKeyCode() == 32) {
			game.resetBall();
			game.resetBoard();
		} else if (e.getKeyCode() == 61) {
			game.getBalls().get(0).setSpeed(game.getBalls().get(0).getSpeed() + 100);
		} else if (e.getKeyCode() == 45) {
			game.getBalls().get(0).setSpeed(game.getBalls().get(0).getSpeed() - 100);
			if (game.getBalls().get(0).getSpeed() <= 0) {
				game.getBalls().get(0).setSpeed(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37) {
			game.getBoard().setSpeed(0);
		} else if (e.getKeyCode() == 39) {
			game.getBoard().setSpeed(0);
		}
	}

}
