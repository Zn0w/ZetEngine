package com.znow.zetengine;

import java.awt.image.DataBufferInt;

import com.znow.zetengine.gfx.Image;

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
	
	public void setPixel(int x, int y, int value) {
		// If out of bounds then do nothing
		if (x < 0 || x >= pW || y < 0 || y >= pH || value == 0xffff00ff) { // Value has pink color for not rendering
			return;
		}
		
		pixels[x + y * pW] = value; // Code in the squared bounds is converting 2 dimensional data to the 1 dimensional array
	}
	
	public void drawImage(Image image, int offX, int offY) {
		int newX = 0;
		int newY = 0;
		int newWidth = image.getWidth();
		int newHeight = image.getHeight();
		
		// Don't render code
		if (offX < -newWidth)
			return;
		if (offY < -newHeight)
			return;
		if (offX >= pW)
			return;
		if (offY >= pH)
			return;
		
		// If the image is out of the screen then don't draw this peace of image (Clipping code)
		if (newX + offX < 0)
			newX -= offX;
		if (newY + offY < 0)
			newY -= offY;
		if (newWidth + offX >= pW)
			newWidth = newWidth - (newWidth + offX - pW);
		if (newHeight + offY >= pH)
			newHeight = newHeight - (newHeight + offY - pH);
		
		// Drawing
		for (int y = newY; y < newHeight; y++) {
			for (int x = newX; x < newWidth; x++) {
				setPixel(x + offX, y + offY, image.getPixels()[x + y * image.getWidth()]);
			}
		}
	}
}
