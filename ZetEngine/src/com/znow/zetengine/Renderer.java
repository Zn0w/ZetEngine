package com.znow.zetengine;

import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

	public void init() {
		glMatrixMode(GL_PROJECTION);
		glOrtho(0, 1280, 720, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_TEXTURE_2D);
		//glEnable(GL_BLEND);
		//glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public void prepare() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); // Clears window
		GL11.glClearColor(1, 0, 0, 1);
	}
	
	public void render(GameObject model) {
		model.draw();
	}

}
