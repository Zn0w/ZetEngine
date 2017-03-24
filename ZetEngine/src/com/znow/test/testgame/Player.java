package com.znow.test.testgame;

import org.lwjgl.input.Keyboard;

import com.znow.zetengine.GameObject;

public class Player extends GameObject {

	private int speed = 5;
	private boolean dead;
	
	public Player(int sx, int sy, int sw, int sh, String tag) {
		super(sx, sy, sw, sh, tag);
	}

	@Override
	public void init() {
		dead = false;
	}

	@Override
	public void awake() {
		
	}

	@Override
	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			y -= speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			y += speed; 
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			x += speed;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			x -= speed;
		}
		
		if (isHitting("wall"))
			System.out.println("Collision detected");
		if (isHitting("food"))
			System.out.println("Nyam-nyam!");
		if (isHitting("killwall"))
			dead = true;
	}

	public boolean isDead() {
		return dead;
	}

}
