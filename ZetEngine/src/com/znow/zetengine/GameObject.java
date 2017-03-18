package com.znow.zetengine;

import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.util.Rectangle;

public abstract class GameObject {

	protected int x, y, w, h;
	
	protected boolean visible = true;
	protected boolean active = true;
	
	public static ArrayList<GameObject> renderObjects = new ArrayList<GameObject>();
	public static HashMap<String, GameObject> objects = new HashMap<String, GameObject>();
	
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
		if (this.x + this.w >= other.x && this.x <= other.x + other.w && this.y + this.h >= other.y && this.y <= other.y + other.h)
			return true;
		return false;
	}
	
	private String getCollisionSide(GameObject other) {
		if (this.x + this.w >= other.x && this.x + this.w <= other.x + other.w && this.y + this.h >= other.y && this.y <= other.y + other.h)
			return "right";
		if (this.x <= other.x + this.w && this.x >= other.x + other.w && this.y + this.h >= other.y && this.y <= other.y + other.h)
			return "left";
		if (this.y + this.h >= other.y && this.y + this.h <= other.y + other.h && this.x + this.w >= other.x && this.x <= other.x + other.w)
			return "down";
		if (this.y <= other.y + other.h && this.y >= other.y + other.h && this.x >= other.x && this.x <= other.x + other.w)
			return "up";
		return null;
	}
	
	public String getCollisionSide(String tag) {
		if (isHitting(objects.get(tag))) {
			return getCollisionSide(objects.get(tag));
		}
		return null;
	}
	
	private boolean isHittingX(GameObject other) {
		if (this.x + this.w > other.x && this.x < other.x + other.w)
			return true;
		return false;
	}
	
	private boolean isHittingY(GameObject other) {
		if (this.y + this.h > other.y && this.y < other.y + other.h)
			return true;
		return false;
	}
	
	public boolean isHitting(String tag) {
		if (isHitting(objects.get(tag)))
			return true;
		return false;
	}
	
	public boolean isHittingX(String tag) {
		return isHittingX(objects.get(tag));
	}
	
	public boolean isHittingY(String tag) {
		return isHittingY(objects.get(tag));
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
	