package com.znow.test;

import java.awt.event.KeyEvent;

import com.znow.zetengine.AbstractGame;
import com.znow.zetengine.GameContainer;
import com.znow.zetengine.Renderer;
import com.znow.zetengine.gfx.Image;

public class TestGame extends AbstractGame {

	private Image image;
	
	public TestGame() {
		image = new Image("/test.png");
	}
	
	public static void main(String[] args) {
		GameContainer gc = new GameContainer(new TestGame());
		gc.start();
	}

	@Override
	public void update(GameContainer gc, float deltaTime) {
		if (gc.getInput().isKeyDown(KeyEvent.VK_F)) {
			System.out.println("F is pressed");
		}
	}

	@Override
	public void render(GameContainer gc, Renderer renderer) {
		renderer.drawImage(image, gc.getInput().getMouseX() - 32, gc.getInput().getMouseY() - 32);
	}
}