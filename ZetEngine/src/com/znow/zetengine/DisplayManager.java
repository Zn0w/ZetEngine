package com.znow.zetengine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

import com.znow.test.Player;
import com.znow.test.Wall;
import com.znow.zetengine.level.Level;

public class DisplayManager {
	
	private static int WIDTH = 1200;
	private static int HEIGHT = 700;
	private static int FPS_CAP = 60;
	private static String title = "Game";
	
	public static void init(int w, int h, String s_title) {
		WIDTH = w;
		HEIGHT = h;
		title = s_title;
	}
	
	public static void init(int w, int h, String s_title, int fps) {
		WIDTH = w;
		HEIGHT = h;
		FPS_CAP = fps;
		title = s_title;
	}
	
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
