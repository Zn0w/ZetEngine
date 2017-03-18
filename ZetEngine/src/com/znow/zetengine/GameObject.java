package com.znow.zetengine;

import static org.lwjgl.opengl.GL11.*;
import java.util.ArrayList;

import org.lwjgl.util.Rectangle;

public abstract class GameObject {

	protected int x, y, w, h;
	public static ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public abstract void init();
	
	public abstract void awake();
	
	public abstract void update();
	
	public GameObject(int sx, int sy, int sw, int sh) {
		x = sx;
		y = sy;
		w = sw;
		h = sh;
	}
	
	public void draw() {
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + w, y);
		glVertex2f(x + w, y + h);
		glVertex2f(x, y + h);
		glEnd();
	}
}
	