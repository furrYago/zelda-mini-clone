package br.com.zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Player extends Rectangle {

	public boolean up, down, left, right, shoot = false;
	public int spd = 4;
	public int curAnimation = 0, curFrames = 0, targetFrames = 15, dirX = 1, dirY = 0;

	public static List<Bullet> bullets = new ArrayList<>();

	public Player(int x, int y) {
		super(x, y, 32, 32);
	}

	public void tick() {
		boolean moved = false;
		if (right && World.isFree(x + spd, y)) {
			x += spd;
			moved = true;
			dirX = 1;
			dirY = 0;
		} else if (left && World.isFree(x - spd, y)) {
			x -= spd;
			moved = true;
			dirX = -1;
			dirY = 0;
		}
		if (up && World.isFree(x, y - spd)) {
			y -= spd;
			moved = true;
			dirX = 0;
			dirY = -1;

		} else if (down && World.isFree(x, y + spd)) {
			y += spd;
			moved = true;
			dirX = 0;
			dirY = 1;
		}
		if (moved) {
			curFrames++;
			if (curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if (curAnimation == Spritesheet.playerAnimation.length)
					curAnimation = 0;
			}
		}

		if (shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, dirX, dirY));
		}

		for (Bullet b : bullets) {
			b.tick();
		}
	}

	public void render(Graphics g) {
		g.drawImage(Spritesheet.playerAnimation[curAnimation], x, y, 32, 32, null);

		for (Bullet b : bullets) {
			b.render(g);
		}
	}

}
