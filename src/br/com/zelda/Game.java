package br.com.zelda;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public static Player player;
	public World world;
	public List<Enemy> enemies = new ArrayList<>();

	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		player = new Player(32, 32);
		enemies.add(new Enemy(64, 64));
		enemies.add(new Enemy(33, 80));

		world = new World();

		new Spritesheet();
	}

	@Override
	public void run() {
		while (true) {
			try {
				tick();
				render();
				Thread.sleep(1000 / 60);
			} catch (Exception e) {
			}
		}
	}

	public void tick() {
		player.tick();

		for (Enemy enemy : enemies) {
			enemy.tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0, 135, 13));
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

		world.render(g);
		player.render(g);

		for (Enemy enemy : enemies) {
			enemy.render(g);
		}

		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();

		frame.add(game);
		frame.setTitle("VAI TAKE NO COOL");
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setIconImage(new ImageIcon("res/link.jpg").getImage());

		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

		new Thread(game).start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
			player.right = true;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
			player.left = true;
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
			player.up = true;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
			player.down = true;
		else if (e.getKeyCode() == KeyEvent.VK_Z)
			player.shoot = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
			player.right = false;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
			player.left = false;
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
			player.up = false;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
			player.down = false;
	}

}
