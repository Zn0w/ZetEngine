package com.znow.zetengine;

import java.awt.image.DataBufferInt;

public class Renderer {

	private int pW, pH; // Pixel width and height
	private int[] pixels;
	
	public Renderer(GameContainer gc) {
		pW = gc.getWidth();
		pH= gc.getHeight();
		pixels = ((DataBufferInt) gc.getWindow().getImage().getRaster().getDataBuffer()).getData(); // Get all pixels that has image
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0; // Just clear every pixel
		}
	}
}
