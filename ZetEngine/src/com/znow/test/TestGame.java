package com.znow.test;

import com.znow.zetengine.GameContainer;
import com.znow.zetengine.GameObject;
import com.znow.zetengine.DisplayManager;
import com.znow.zetengine.ZetGame;

public class TestGame extends ZetGame {

	private GameObject box;
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(720, 480, "TestGame", new TestGame());
		gc.start();
	}

	@Override
	public void init() {
		box = new GameObject(400, 350, 50, 50);
	}

	@Override
	public void render(GameContainer gc, DisplayManager renderer) {
		box.draw(renderer);
	}

	@Override
	public void update(GameContainer gc) {
		
	}
}