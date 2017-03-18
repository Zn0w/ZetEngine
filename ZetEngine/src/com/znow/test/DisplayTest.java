package com.znow.test;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Rectangle;

import com.znow.zetengine.DisplayManager;
import com.znow.zetengine.GameObject;
import com.znow.zetengine.Renderer;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;


public class DisplayTest {

	public static void main(String[] args) {
		Renderer renderer = new Renderer();
		
		Player player = new Player(400, 400, 50, 50);
		Wall rightWall = new Wall(600, 100, 20, 800);
		
		DisplayManager.createDisplay();
		
		renderer.init();
		
		/*glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 1280, 720, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_TEXTURE_2D);*/
		
		while (!Display.isCloseRequested()) {
			renderer.prepare();
			
			/*player.update();
			renderer.render(player);*/
			
			for (int i = 0; i < GameObject.objects.size(); i++) {
				GameObject object = GameObject.objects.get(i);
				if (object.isActive())
					object.update();
				if (object.isVisible())
					object.draw();
			}
			
			DisplayManager.updateDisplay();
		}
		
		DisplayManager.closeDisplay();
	}
	
}
