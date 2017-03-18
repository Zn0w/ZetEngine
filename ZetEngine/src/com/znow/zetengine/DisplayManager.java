package com.znow.zetengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	private static int FPS_CAP = 60;
	private static String title = "TestGame";
	
	public static void createDisplay() {
		
		// Not working with this
		//ContextAttribs attribs = new ContextAttribs(3, 2);
		//attribs.withForwardCompatible(true);
		//attribs.withProfileCompatibility(true);
		
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
