package com.znow.test.examples.pong;

import org.lwjgl.input.Keyboard;

import com.znow.test.examples.pong.objects.*;
import com.znow.zetengine.GameContainer;
import com.znow.zetengine.ZetGame;

public class PongMain extends ZetGame {

	private Background background = new Background(0, 0, 1280, 720, "backgound");
	private Board boardL, boardR;
	private Ball ball;
	
	public static void main(String[] args) {
		GameContainer game = new GameContainer(1280, 720, "PongGame", new PongMain(), 60);
		game.start();
	}

	@Override
	public void init() {
		background.setColour(0.5F,0.8f , 9.0f);
		
		boardL = new Board(50, 320, 20, 80, "board", 17, 31);
		boardL.setActive(false);
		boardR = new Board(1210, 320, 20, 80, "board", 200, 208);
		boardR.setActive(false);
		
		ball = new Ball(630, 350, 10, 10, "ball");
		ball.setActive(false);
	}

	@Override
	public void update(GameContainer gc) {
		if (Keyboard.isKeyDown(28)) {
			boardL.setActive(true);
			boardR.setActive(true);
			ball.setActive(true);
		}
		
		if (Keyboard.isKeyDown(1)) {
			boardL.setActive(false);
			boardR.setActive(false);
			ball.setActive(false);
		}
		
		if (ball.isOutOfBounds()) {
			boardL.respawn(50, 320);
			boardR.respawn(1210, 320);
			ball.respawn(630, 350);
		}
	}

}
