package com.znow.test;

import com.znow.zetengine.GameObject;
import org.lwjgl.input.*;

public class Player extends GameObject {

	private static int SPEED = 1;
	
	private int speedUp = SPEED;
	private int speedDown = SPEED;
	private int speedRight = SPEED;
	private int speedLeft = SPEED;
	
	public Player(int x, int y, int w, int h, String tag) {
		super(x, y, w, h, tag);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void awake() {
		
	}

	@Override
	public void update() {
		// Player controls
		
		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			this.y -= speedUp;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			this.y += speedDown;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			this.x += speedRight;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			this.x -= speedLeft;
		}
		
		speedUp = SPEED;
		speedDown = SPEED;
		speedLeft = SPEED;
		speedRight = SPEED;
		
		// Collision handling
		
		if (getCollisionSide("wall") == "right")
			speedRight = 0;
		if (getCollisionSide("wall") == "left")
			speedLeft = 0;
		if (getCollisionSide("wall") == "up")
			speedDown = 0;
		if (getCollisionSide("wall") == "down")
			speedUp = 0;
		
		// Just testing
		
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			visible = false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			visible = true;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			active = false;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
			active = true;
		}
	}

}
