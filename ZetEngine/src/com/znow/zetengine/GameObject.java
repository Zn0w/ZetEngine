package com.znow.zetengine;

import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.util.Rectangle;

import com.znow.zetengine.level.Level;

public abstract class GameObject {

	protected int x, y, w, h;
	
	protected boolean visible = true;
	protected boolean active = true;
	
	public static ArrayList<GameObject> renderObjects = new ArrayList<GameObject>();
	public static HashMap<String, GameObject> objects = new HashMap<String, GameObject>();
	//public static ArrayList<GameObject> staticObjects = new ArrayList<GameObject>();
	
	//private String tag;
	
	public abstract void init();
	
	public abstract void awake();
	
	public abstract void update();
	
	public GameObject(int sx, int sy, int sw, int sh, String tag) {
		x = sx;
		y = sy;
		w = sw;
		h = sh;
		
		renderObjects.add(this);
		
		objects.put(tag, this);
	}
	
	public GameObject(int sx, int sy, int sw, int sh, String tag, Level level) {
		x = sx;
		y = sy;
		w = sw;
		h = sh;
		
		renderObjects.add(this);
		
		objects.put(tag, this);
		
		level.putInLevel(this);
	}
	
	public void draw() {
		glColor3f(0.5f, 0.5f, 0.5f);
		
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + w, y);
		glVertex2f(x + w, y + h);
		glVertex2f(x, y + h);
		glEnd();
	}
	
	public String checkStaticCollision(String tag) {
		GameObject other = objects.get(tag);
		
		boolean colR = false, colL = false, colU = false, colD = false;
		
		if (getCollisionSide("wall", "horizontal") == "right") {
			colR = true;
		}
		if (getCollisionSide("wall", "vertical") == "up") {
			colU = true;
		}
		if (getCollisionSide("wall", "horizontal") == "left") {
			colL = true;
		}
		if (getCollisionSide("wall", "vertical") == "down") {
			colD = true;
		}
		
		if (colR && colD) {
			if (y + h > other.y)
				return "r";
		}
		else return "d";
		
		if (colR && colU) {
			if (y > other.y + other.h)
				return "r";
		}
		else return "u";
		
		if (colL && colU) {
			if (y > other.y + other.h)
				return "l";
		}
		else return "u";
		
		if (colL && colD) {
			if (y + h > other.y)
				return "l";
		}
		else return "d";
		
		if (isHitting("wall")) {
			System.out.println("Collision detected");
		}
		
		return null;
	}
	
	private boolean isHitting(GameObject other) {
		if (x + w >= other.x && x <= other.x + other.w && y + h >= other.y && y <= other.y + other.h)
			return true;
		return false;
	}
	
	private String getCollisionSideHorizontal(GameObject other) {
		if (x + w >= other.x && x + w <= other.x + other.w && y + h >= other.y && y <= other.y + other.h)
			return "right";
		if (x >= other.x && x <= other.x + other.w && y + h >= other.y && y <= other.y + other.h)
			return "left";
		return null;
	}
	
	private String getCollisionSideVertical(GameObject other) {
		if (y <= other.y + other.h && y + h >= other.y + other.h && x + w >= other.x && x <= other.x + other.w)
			return "up";
		if (y + h <= other.y + other.h && y + h >= other.y && x + w >= other.x && x <= other.x + other.w)
			return "down";
		return null;
	}
	
	public String getCollisionSide(String tag, String axis) {
		if (isHitting(objects.get(tag))) {
			if (axis == "horizontal")
				return getCollisionSideHorizontal(objects.get(tag));
			if (axis == "vertical")
				return getCollisionSideVertical(objects.get(tag));
		}
		return null;
	}
	
	public boolean isHitting(String tag) {
		if (isHitting(objects.get(tag)))
			return true;
		return false;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public boolean isActive() {
		return active;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
}
	