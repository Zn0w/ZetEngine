package com.znow.zetengine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.RenderedImage;

public class Renderer {

	private BufferedImage image;
	private int[] pixels;
	
	public Renderer(int width, int height) {
		// This image will represent game view
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// Array for pixels
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}
	
	public void render(Graphics g) {
		for(int index = 0; index < pixels.length; index++) {
			pixels[index] = (int)(Math.random() * 0xFFFFFF);
		}
		
		g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
	}
}
