package br.com.zelda;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	public static List<Obstacle> obstacles = new ArrayList<>();

	public World() {
		for (int xx = 0; xx < 15 * 2; xx++) {
			obstacles.add(new Obstacle(xx * 32, 0));
			obstacles.add(new Obstacle(xx * 32, 448));
		}

		for (int yy = 0; yy < 15 * 2; yy++) {
			obstacles.add(new Obstacle(0, yy * 32));
			obstacles.add(new Obstacle(608, yy * 32));
		}
		
		obstacles.add(new Obstacle(120, 80));

	}

	public void render(Graphics g) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).render(g);
		}
	}

	public static boolean isFree(int x, int y) {
		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle current = obstacles.get(i);
			if (current.intersects(new Rectangle(x, y, 32, 32)))
				return false;

		}

		return true;
	}

}
