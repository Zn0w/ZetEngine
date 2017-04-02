package com.znow.zetengine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.util.ArrayList;

public class Menu {
	
	public static ArrayList<Menu> menues = new ArrayList<Menu>();
	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	private boolean active = false;
	
	private float red, green, blue;
	
	public Menu() {
		menues.add(this);
	}
	
	public void setBackgroundColor(float r, float g, float b) {
		red = r;
		green = g;
		blue = b;
	}
	
	public void draw(GameContainer gc) {
		glColor3f(red, green, blue);
		
		glBegin(GL_QUADS);
		glVertex2f(0, 0);
		glVertex2f(gc.getWidth(), 0);
		glVertex2f(gc.getWidth(), gc.getHeight());
		glVertex2f(0, gc.getHeight());
		glEnd();
		
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).draw();
		}
	}
	
	public void update() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).update();
		}
	}
	
	public void addButton(Button button) {
		buttons.add(button);
	}
	
	public void setActive(boolean b) {
		active = b;
	}
	
	public boolean isActive() {
		return active;
	}
	
}
