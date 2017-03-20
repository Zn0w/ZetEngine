package com.znow.test.LevelLoadingTest;

import org.lwjgl.opengl.Display;

import com.znow.test.Player;
import com.znow.test.Wall;
import com.znow.zetengine.DisplayManager;
import com.znow.zetengine.GameObject;
import com.znow.zetengine.Renderer;
import static org.lwjgl.opengl.GL11.*;

public class Main {

	public static void main(String[] args) {
		Level testLevel = new Level();
		
		Renderer renderer = new Renderer();

		DisplayManager.createDisplay();
		
		renderer.init();
		
		while (!Display.isCloseRequested()) {
			renderer.prepare();
			
			for (int i = 0; i < GameObject.renderObjects.size(); i++) {
				GameObject object = GameObject.renderObjects.get(i);
				if (object.isActive())
					object.update();
				if (object.isVisible())
					object.draw();
			}
			
			for (int y = 0; y < testLevel.h; y++) {
				for (int x = 0; x < testLevel.w; x++) {
					if (testLevel.tileMap[y].charAt(x) == 'B')
						glColor3f(0.0f, 0.0f, 1.0f);
					if (testLevel.tileMap[y].charAt(x) == 'R')
						glColor3f(1.0f, 0.0f, 0.0f);
					if (testLevel.tileMap[y].charAt(x) == ' ')
						continue;
					
					int posX = x * 32;
					int posY = y * 32;
						
					glBegin(GL_QUADS);
					glVertex2f(posX, posY);
					glVertex2f(posX + 32, posY);
					glVertex2f(posX + 32, posY + 32);
					glVertex2f(posX, posY + 32);
					glEnd();
				}
			}
			
			DisplayManager.updateDisplay();
		}
		
		DisplayManager.closeDisplay();
	}

}
