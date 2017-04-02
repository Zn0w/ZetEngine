package com.znow.test.collisiontest;

import com.znow.zetengine.GameContainer;
import com.znow.zetengine.ZetGame;

public class TestMain extends ZetGame {

	private Player player;
	private Obastacle wall;
	
	public static void main(String[] args) {
		GameContainer game = new GameContainer(1280, 720, "CollisionTest", new TestMain());
		game.start();
	}
	
	@Override
	public void init() {
		player = new Player(200, 500, 50, 50, "player");
		wall = new Obastacle(300, 60, 500, 600, "wall");
	}

	@Override
	public void update(GameContainer gc) {
		
	}

}
