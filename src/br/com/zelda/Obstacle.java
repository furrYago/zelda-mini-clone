package br.com.zelda;

import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Obstacle extends Rectangle {

	public Obstacle(int x, int y) {
		super(x, y, 32, 32);
	}

	public void render(Graphics g) {
		
		g.drawImage(Spritesheet.tileWall, x, y, 32, 32, null);
	}

}
