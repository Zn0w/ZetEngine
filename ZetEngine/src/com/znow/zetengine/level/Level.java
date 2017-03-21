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
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
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
	
	// TODO: create global tilesArray
	public void registerLevelTileType(char id, float r, float g, float b) {
		Tile tile = new Tile(id, r, g, b);
		tiles.add(tile);
	}
	
	public void render() {
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				char id = map[y].charAt(x);
				boolean exists = false;
				float[] colour = null;
				
				for (int i = 0; i < tiles.size(); i++) {
					if (tiles.get(i).getId() == id) {
						exists = true;
						colour = tiles.get(i).getColour();
						break;
					}
				}
				
				if (exists) {
					glColor3f(colour[0], colour[1], colour[2]);
				}
				
				/*if (map[y].charAt(x) == 'B')
					glColor3f(0.0f, 0.0f, 1.0f);
				if (map[y].charAt(x) == 'R')
					glColor3f(1.0f, 0.0f, 0.0f);
				if (map[y].charAt(x) == ' ')
					continue;*/
				
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
	
	public void checkStaticCollisionX(char id, GameObject object) {
		for (int i = object.getY() / 32; i < (object.getY() + object.getH()) / 32; i++) {
			for (int j = object.getX() / 32; j < (object.getX() + object.getW()) / 32; j++) {
				if (map[i].charAt(j) == id) {
					int posX = j * 32;
					int posY = i * 32;
					
					if (object.getX() + object.getW() > posX)
						object.setX(posX - object.getW());
					else object.setX(posX + 32);
				}
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
