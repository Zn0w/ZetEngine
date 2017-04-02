package com.znow.zetengine;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

import com.znow.zetengine.level.Level;

public class GameContainer implements Runnable {

	private ZetGame game;
	private boolean running = false;
	private Thread gameThread;
	
	private int width, height;
	
	public GameContainer(int s_width, int s_height, String s_title, ZetGame s_game) {
		game = s_game;
		DisplayManager.init(s_width, s_height, s_title, 60);
		
		width = s_width;
		height = s_height;
	}
	
	public GameContainer(int s_width, int s_height, String s_title, ZetGame s_game, int fps) {
		game = s_game;
		DisplayManager.init(s_width, s_height, s_title, fps);
		
		width = s_width;
		height = s_height;
	}
	
	public void start() {
		running = true;
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		game.init();
		
		Renderer renderer = new Renderer();
		
		DisplayManager.createDisplay();
		
		renderer.init();
		
		for (int i = 0; i < GameObject.renderObjects.size(); i++) {
			GameObject object = GameObject.renderObjects.get(i);
			object.init();
		}
		
		while (!Display.isCloseRequested()) {
			renderer.prepare();
			
			game.update(this);
			
			if (Menu.menues.size() > 0) {
				for (int i = 0; i < Menu.menues.size(); i++) {
					Menu menu = Menu.menues.get(i);
					
					if (menu.isActive()) {
						menu.draw(this);
						menu.update();
					}
				}
			}
			
			if (running) {
				if (Level.levels.size() > 0) {
					for (int i = 0; i < Level.levels.size(); i++) {
						Level level = Level.levels.get(i);
						if (level.isActive()) {
							level.render();
							level.renderLevelObjects();
						}
					}
				}
				
				else {
					for (int i = 0; i < GameObject.renderObjects.size(); i++) {
						GameObject object = GameObject.renderObjects.get(i);
						if (object.isActive())
							object.update();
						if (object.isVisible())
							object.draw();
					}
				}
			}
			
			DisplayManager.updateDisplay();
		}
		
		DisplayManager.closeDisplay();
		
		dispose();
	}
	
	public void stop() {
		
	}
	
	public void dispose() {
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
