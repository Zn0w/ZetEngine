package com.znow.zetengine;

import java.util.ArrayList;

public class GameContainer implements Runnable {

	private ZetGame game;
	
	private Thread thread;
	//private DisplayManager renderer;
	private Input input;
	
	private boolean isRunning = false;
	private final int FPS_CAP = 60;
	
	// Data for game window
	private int width, height;
	private String title;
	
	public GameContainer(int s_width, int s_height, String s_title, ZetGame s_game) {
		width = s_width;
		height = s_height;
		title = s_title + " powered by ZetEngine";
		game = s_game;
	}
	
	public void start() {
		//renderer = new DisplayManager();
		input = new Input(this);
		
		isRunning = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		//renderer.start();
		
		while (isRunning) {	
			game.update(this);
			//game.render(this, renderer);
		}
		
		dispose();
	}
	
	public void stop() {
		
	}
	
	public void dispose() {
		
	}

	// Getters and setters
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}
}
