package arkanoid;

import java.awt.Color;
import java.util.ArrayList;

public class Game {

	private static final Color[] COLORS = 
		{Color.LIGHT_GRAY, Color.RED, Color.YELLOW, 
				Color.CYAN, Color.MAGENTA, Color.GREEN};
	
	private ArrayList<Sprite> blocks = new ArrayList<>();
	
	public Game() {
		for (int j = 0; j < 6; j++) {
			for (int i = 0; i < 10; i++) {
				Block block = new Block(47, 17, COLORS[j]);
				blocks.add(block);
				block.setX(3 + i * 50);
				block.setY(60 + j * 20);
			}
		}
	}
	
	public ArrayList<Sprite> getBlocks() {
		return blocks;
	}
	
	public void removeBlock(Block block) {
		blocks.remove(block);
	}
	
	
}
