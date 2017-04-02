package com.znow.zetengine;

import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;

public class Renderer {

	public void init() {
		glMatrixMode(GL_PROJECTION);
		glOrtho(0, 1280, 720, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	
	public void prepare() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); // Clears window
		GL11.glClearColor(1, 1, 1, 1);
	}
	
}
