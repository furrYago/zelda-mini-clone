package br.com.zelda;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet, tileWall;
	public static BufferedImage[] playerAnimation;
	public static BufferedImage[] enemyAnimation;

	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
			playerAnimation = new BufferedImage[2];
			enemyAnimation = new BufferedImage[2];

			playerAnimation[0] = Spritesheet.getSprite(0, 11, 16, 16);
			playerAnimation[1] = Spritesheet.getSprite(16, 11, 16, 16);

			enemyAnimation[0] = Spritesheet.getSprite(299, 222, 16, 16);
			enemyAnimation[1] = Spritesheet.getSprite(327, 222, 16, 16);

			tileWall = Spritesheet.getSprite(280, 221, 16, 16);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}

}
