package com.znow.zetengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 700;
	private static int FPS_CAP = 60;
	private static String title = "TestGame";
	
	public static void createDisplay() {
		try {
			
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
			Display.setTitle(title + " powered by ZetEngine");
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		// To display image on the whole window
		GL11.glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay() {
		Display.destroy();
	}
}
