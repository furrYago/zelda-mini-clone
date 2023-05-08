package br.com.zelda;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet, playerFront, tileWall;

	public Spritesheet() {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
			playerFront = Spritesheet.getSprite(0, 11, 16, 16);
			tileWall = Spritesheet.getSprite(280, 221, 16, 16);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}

}
