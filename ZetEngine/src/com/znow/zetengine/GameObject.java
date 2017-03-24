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
	public static HashMap<String, ArrayList<GameObject>> objects = new HashMap<String, ArrayList<GameObject>>();
	
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
		
		if (objects.get(tag) != null) {
			ArrayList<GameObject> objs = objects.get(tag);
			objs.add(this);
			objects.put(tag, objs);
		}
		else {
			ArrayList<GameObject> objs = new ArrayList<GameObject>();
			objs.add(this);
			objects.put(tag, objs);
		}
	}
	
	public GameObject(int sx, int sy, int sw, int sh, String tag, Level level) {
		x = sx;
		y = sy;
		w = sw;
		h = sh;
		
		renderObjects.add(this);
		
		if (objects.get(tag) != null) {
			ArrayList<GameObject> objs = objects.get(tag);
			objs.add(this);
			objects.put(tag, objs);
		}
		else {
			ArrayList<GameObject> objs = new ArrayList<GameObject>();
			objs.add(this);
			objects.put(tag, objs);
		}
		
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
		ArrayList<GameObject> objs = objects.get(tag);
		
		for (int i = 0; i < objs.size(); i++) {
			if (isHitting(objs.get(i))) {
				if (axis == "horizontal")
					return getCollisionSideHorizontal(objs.get(i));
				if (axis == "vertical")
					return getCollisionSideVertical(objs.get(i));
			}
		}
		
		return null;
	}
	
	public boolean isHitting(String tag) {
		ArrayList<GameObject> objs = objects.get(tag);
		
		for (int i = 0; i < objs.size(); i++) {
			if (isHitting(objs.get(i)))
				return true;
		}
		
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
	