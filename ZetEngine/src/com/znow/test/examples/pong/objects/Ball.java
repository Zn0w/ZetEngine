package com.znow.test.examples.pong.objects;

import java.util.Random;

import com.znow.zetengine.GameObject;

public class Ball extends GameObject {

	private double speedX = 7;
	private double speedY = 3;
	
	private boolean outOfBounds = false;
	
	public Ball(int sx, int sy, int sw, int sh, String tag) {
		super(sx, sy, sw, sh, tag);
	}

	@Override
	public void init() {
		Random rand = new Random(); 
		int value = rand.nextInt(2); 
		
		if (value == 1)
			speedX *= -1;
	}

	@Override
	public void awake() {
		
	}

	@Override
	public void update() {
		if (x > 0 && x < 1280) {
			x += speedX;
			y += speedY;
			
			outOfBounds = false;
		}
		else {
			outOfBounds = true;
			
			if (speedX > 0)
				speedX = 7;
			else speedX = -7;
			
			if (speedY > 0)
				speedY = 3;
			else speedY = -3;
		}
		
		if (getCollisionSide("board", "horizontal") == "right" || getCollisionSide("board", "horizontal") == "left") {
			speedX *= -1;
			
			if (speedX > 0)
				speedX += 0.5;
			else speedX -= 0.5;
			
			if (speedY > 0)
				speedY += 0.5;
			else speedY -= 0.5;
		}
		
		if (y <= 0 || y >= 720)
			speedY *= -1;
		
		System.out.println("speed x: " + speedX + "  speed y: " + speedY);
	}
	
	public boolean isOutOfBounds() {
		return outOfBounds;
	}
	
	public void respawn(int sx, int sy) {
		x = sx;
		y = sy;
	}

}
