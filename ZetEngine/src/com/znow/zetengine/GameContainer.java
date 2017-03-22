package com.znow.zetengine;

import java.util.ArrayList;

public class GameContainer implements Runnable {

	private ZetGame game;
	private boolean running = false;
	private Thread gameThread;
	
	public GameContainer(int s_width, int s_height, String s_title, ZetGame s_game) {
		
		game = s_game;
	}
	
	public void start() {
		running = true;
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void run() {
		
		while (running) {	
			game.update(this);
			DisplayManager.renderDisplay();
		}
		
		dispose();
	}
	
	public void stop() {
		
	}
	
	public void dispose() {
		
	}

}
