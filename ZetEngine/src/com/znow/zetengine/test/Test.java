package com.znow.zetengine.test;

import com.znow.zetengine.Game;

public class Test {

	public static void main(String[] args) {
		Game game = new Game();
		Thread gameThread = new Thread();
		gameThread.start();
	}
}
