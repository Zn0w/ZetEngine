package com.znow.test.examples.pong.objects;

import com.znow.zetengine.GameObject;
import org.lwjgl.input.*;

public class Board extends GameObject {

	private int speed = 4;
	private int keyUp, keyDown;
	
	public Board(int sx, int sy, int sw, int sh, String tag, int sKeyUp, int sKeyDown) {
		super(sx, sy, sw, sh, tag);
		
		keyUp = sKeyUp;
		keyDown = sKeyDown;
	}

	@Override
	public void init() {
		
	}

	@Override
	public void awake() {
		 
	}

	@Override
	public void update() {
		if (Keyboard.isKeyDown(keyUp) && y > 0)
			y -= speed;
		if (Keyboard.isKeyDown(keyDown) && (y + h) < 720)
			y += speed;
	}
	
	public void respawn(int sx, int sy) {
		x = sx;
		y = sy;
	}

}
