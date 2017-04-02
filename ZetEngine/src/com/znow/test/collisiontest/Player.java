package com.znow.test.collisiontest;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.znow.zetengine.GameObject;

public class Player extends GameObject {

	private int speedX = 5;
	private int speedY = 5;
	
	public Player(int sx, int sy, int sw, int sh, String tag) {
		super(sx, sy, sw, sh, tag);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void awake() {
		
	}

	@Override
	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			y -= speedY;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			y += speedY; 
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			x += speedX;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			x -= speedX;
		}
		
		boolean colX = false;
		
		if (!colX) {
			if (getCollisionSide("wall", "vertical") == "up")
				y += 5;
			else if (getCollisionSide("wall", "vertical") == "down")
				y -= 5;
			else colX = false;
		}
		
		if (getCollisionSide("wall", "horizontal") == "right") {
			x -= 5;
			colX = true;
		}
		else if (getCollisionSide("wall", "horizontal") == "left") {
			x += 5;
			colX = true;
		}
		else colX = false;
	}
	
	private String getCollisionSideHorizontal(GameObject other) {
		if (x + w >= other.x && x + w <= other.x + other.w && x < other.x && y + h >= other.y && y <= other.y + other.h)
			return "right";
		else if (x >= other.x && x <= other.x + other.w && y + h >= other.y && y <= other.y + other.h)
			return "left";
		return null;
	}
	
	private String getCollisionSideVertical(GameObject other) {
		if (y <= other.y + other.h && y + h >= other.y + other.h && x + w >= other.x && x <= other.x + other.w)
			return "up";
		else if (y + h <= other.y + other.h && y + h >= other.y && y < other.y && x + w >= other.x && x <= other.x + other.w )
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
	
	private boolean isHitting(GameObject other) {
		if (x + w >= other.x && x <= other.x + other.w && y + h >= other.y && y <= other.y + other.h)
			return true;
		return false;
	}

}
