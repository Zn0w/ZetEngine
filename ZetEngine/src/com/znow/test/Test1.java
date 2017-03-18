package com.znow.test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Test1 {

	private Graphics2D imageGraphics;
	private JFrame frame = new JFrame();
	private BufferedImage image;
	
	public Test1() {
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		imageGraphics = (Graphics2D) image.getGraphics();
	}
	
	public void draw() {
		Graphics g = frame.getGraphics();
		g.drawImage(image, 0, 0, null);
	}
	
	public void render(int x, int y, int w, int h) {
		imageGraphics.setColor(Color.orange);
		imageGraphics.fillRect(x, y, w, h);
	}
}
