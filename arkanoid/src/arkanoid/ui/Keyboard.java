package arkanoid.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import arkanoid.Game;

public class Keyboard extends KeyAdapter {
	
	public static final int LEFT = 37;
	public static final int RIGHT = 39;
	private Game game;
 	
	public Keyboard(Game game) {
		this.game = game;
	}
	
	@Override
	public  void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 37) {
			game.moveBoard(-30);
		} else if (e.getKeyCode() == 39) {
			game.moveBoard(30);
		}
	}
	
	
}
