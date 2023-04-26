package br.com.zelda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Obstacle extends Rectangle {

	public Obstacle(int x, int y) {
		super(x, y, 32, 32);
	}

	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}

}
