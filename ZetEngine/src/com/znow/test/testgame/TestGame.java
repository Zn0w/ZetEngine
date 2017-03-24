package com.znow.test.testgame;

import com.znow.zetengine.GameContainer;
import com.znow.zetengine.GameObject;
import com.znow.zetengine.ZetGame;

public class TestGame extends ZetGame {
	
	public static void main(String[] args) {
		GameContainer game = new GameContainer(1200, 720, "TestGame", new TestGame(),  60);
		
		Player player = new Player(600, 360, 50, 50, "player");
		
		Wall wall1 = new Wall(100, 50, 30, 600, "wall");
		Wall wall2 = new Wall(1000, 50, 30, 600, "wall");
		
		Food food = new Food(700, 500, 40, 40, "food");
		
		Wall killWall = new Wall(100, 680, 800, 20, "killwall");
		
		game.start();
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update(GameContainer gc) {
		
	}

}
