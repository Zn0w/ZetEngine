package com.znow.test;

import com.znow.zetengine.GameObject;
import org.lwjgl.input.*;

public class Player extends GameObject {

	private static int SPEED = 5;
	
	public Player(int x, int y, int w, int h) {
		super(x, y, w, h);
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
			this.y -= SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			this.y += SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			this.x += SPEED;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			this.x -= SPEED;
		}
	}
	
	

}
