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
				
		if (getCollisionSide("wall", "vertical") == "up")
			y += 5;
		else if (getCollisionSide("wall", "vertical") == "down")
			y -= 5;
		
		if (getCollisionSide("wall", "horizontal") == "right")
			x -= 5;
		else if (getCollisionSide("wall", "horizontal") == "left")
			x += 5;
	}

}
