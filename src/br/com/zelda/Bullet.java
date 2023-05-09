package br.com.zelda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Bullet extends Rectangle {

	public int dirX = 1, dirY = 0, speed = 8, frames = 0;

	public Bullet(int x, int y, int dirX, int dirY) {
		super(x + 16, y + 16, 10, 10);
		this.dirX = dirX;
		this.dirY = dirY;
	}

	public void tick() {
		x += speed * dirX;
		y += speed * dirY;
		frames++;
		if (frames == 60) {
			Player.bullets.remove(this);
			return;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, width, height);
	}
}
