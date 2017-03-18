package com.znow.zetengine;

public abstract class ZetGame {

	public abstract void init();
	
	public abstract void render(GameContainer gc, DisplayManager renderer);
	
	public abstract void update(GameContainer gc);
}
