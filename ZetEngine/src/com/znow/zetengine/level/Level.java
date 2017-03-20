package com.znow.zetengine.level;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.ArrayList;
import java.util.HashMap;

import com.znow.zetengine.GameObject;

public class Level {

	public static ArrayList<Level> levels = new ArrayList<Level>();
	
	private ArrayList<GameObject> levelObjects = new ArrayList<GameObject>();
	private int w, h;
	private String[] map;
	private HashMap<String, int[]> ids = new HashMap<String, int[]>();
	private boolean active = false;
	
	public Level(int sW, int sH, String[] tileMap) {
		w = sW;
		h = sH;
		map = tileMap;
		
		levels.add(this);
	}
	
	public void putInLevel(GameObject object) {
		levelObjects.add(object);
	}
	
	public void render() {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if (map[y].charAt(x) == 'B')
					glColor3f(0.0f, 0.0f, 1.0f);
				if (map[y].charAt(x) == 'R')
					glColor3f(1.0f, 0.0f, 0.0f);
				if (map[y].charAt(x) == ' ')
					continue;
				
				int posX = x * 32;
				int posY = y * 32;
					
				glBegin(GL_QUADS);
				glVertex2f(posX, posY);
				glVertex2f(posX + 32, posY);
				glVertex2f(posX + 32, posY + 32);
				glVertex2f(posX, posY + 32);
				glEnd();
			}
		}
	}
	
	public boolean isCollide(char id) {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				
			}
		}
	}
	
	public void update() {
		
	}
	
	public void setActive(boolean b) {
		active = b;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
