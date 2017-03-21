package com.znow.test.LevelLoadingTest;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.opengl.Display;

import com.znow.zetengine.DisplayManager;
import com.znow.zetengine.GameObject;
import com.znow.zetengine.Renderer;
import com.znow.zetengine.level.Level;

public class Main {

	public static void main(String[] args) {
		String[] tileMap = {
				"RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR",
				"B                                      B",
				"B                BBBBBBBB              B",
				"B                BBBBBBBB              B",
				"B        BR      BBBBBBBB              B",
				"B                BBBBBBBB              B",
				"B                BBBBBBBB              B",
				"B       BBB      BBBBBBBB              B",
				"B       BBB      BBBBBBBB              B",
				"B                BBBBBBBB              B",
				"B                                      B",
				"BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB",
		};
		
		Level testLevel = new Level(40, 12, tileMap);
		testLevel.registerLevelTileType('B', 0.0f, 0.0f, 1.0f);
		testLevel.registerLevelTileType('R', 1.0f, 0.0f, 0.0f);
		testLevel.registerLevelTileType(' ', 1.0f, 1.0f, 1.0f);
		
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
			
			testLevel.render();
			
			DisplayManager.updateDisplay();
		}
		
		DisplayManager.closeDisplay();
	}

}
