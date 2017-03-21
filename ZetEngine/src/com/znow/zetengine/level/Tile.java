package com.znow.zetengine.level;

public class Tile {

	private char id;
	private float[] colour = new float[3];
	
	public Tile(char id, float r, float g, float b) {
		this.id = id;
		
		colour[0] = r;
		colour[1] = g;
		colour[2] = b;
	}
	
	public char getId() {
		return id;
	}
	
	public float[] getColour() {
		return colour;
	}
	
	public void setColour(float r, float g, float b) {
		colour[0] = r;
		colour[1] = g;
		colour[2] = b;
	}
	
}
