package com.znow.test;

import com.znow.zetengine.GameObject;
import org.lwjgl.input.*;

public class Player extends GameObject {

	private static int SPEED = 5;
	
	private int speedU = SPEED;
	private int speedD = SPEED;
	private int speedR = SPEED;
	private int speedL = SPEED;
	
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
			y -= speedU;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			y += speedD; 
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			x += speedR;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			x -= speedL;
		}
		
		speedU = SPEED;
		speedD = SPEED;
		speedL = SPEED;
		speedR = SPEED;
		
		// Collision handling
		if (isHitting("wall"))
			System.out.println("Collision detected");
		
		/*boolean colR = false, colL = false, colU = false, colD = false;
		
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
		
		if (colR && colU)
			
		
		if (isHitting("wall")) {
			System.out.println("Collision detected");
		}*/
		
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
