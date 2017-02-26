package com.znow.zetengine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable {

	private Canvas canvas = new Canvas();
	private Renderer renderer;
	
	public Game() {
		// set up window
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(canvas);
		setVisible(true);
		
		canvas.createBufferStrategy(3);
		
		renderer = new Renderer(getWidth(), getHeight());
	}
	
	public void update() {
		
	}
	
	public void draw() {
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics g = bufferStrategy.getDrawGraphics();
		super.paint(g);
		
		renderer.render(g);
		g.dispose();
		bufferStrategy.show();
	}
	
	public void run() {
		int i = 0;
		int x = 0;

		long lastTime = System.nanoTime(); //long 2^63
		double nanoSecondConversion = 1000000000.0 / 60; //60 frames per second
		double changeInSeconds = 0;

		/*while (true) {
			long now = System.nanoTime();

			changeInSeconds += (now - lastTime) / nanoSecondConversion;
			while(changeInSeconds >= 1) {
				update();
				changeInSeconds = 0;
			}

			draw();
			lastTime = now;
		}*/
		
		// Testing
		while (true) {
			BufferStrategy bufferStrategy = canvas.getBufferStrategy();
			Graphics graphics = bufferStrategy.getDrawGraphics();
			super.paint(graphics);

			//Painting the Backround
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, getWidth(), getHeight());

			//Painting the Oval
			graphics.setColor(Color.red);		
			graphics.fillOval(x, 200, 50, 100);

			graphics.dispose();
			bufferStrategy.show();
		}
	}
}
