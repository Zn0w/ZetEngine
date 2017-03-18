package com.znow.zetengine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	private GameContainer gc;
	
	private final int KEY_NUM = 256;
	private boolean[] keys = new boolean[KEY_NUM];
	private boolean[] keysLast = new boolean[KEY_NUM];
	
	private final int BUTTON_NUM = 5;
	private boolean[] buttons = new boolean[BUTTON_NUM];
	private boolean[] buttonsLast = new boolean[BUTTON_NUM];
	
	private int mouseX = 0, mouseY = 0;
	private int scroll = 0;
	
	public Input(GameContainer s_gc) {
		gc = s_gc;
		
		// Connect input listeners to the window
		
	}
	
	public void update() {
		for (int i = 0; i < KEY_NUM; i++) {
			keysLast[i] = keys[i];
		}
		
		for (int i = 0; i < BUTTON_NUM; i++) {
			buttonsLast[i] = buttons[i];
		}
	}
	
	public boolean isKey(int keyCode) {
		return keys[keyCode];
	}
	
	public boolean isKeyUp(int keyCode) {
		return !keys[keyCode] && keysLast[keyCode];
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode] && !keysLast[keyCode];
	}
	
	public boolean isButton(int buttonCode) {
		return buttons[buttonCode];
	}
	
	public boolean isButtonUp(int buttonCode) {
		return !buttons[buttonCode] && buttonsLast[buttonCode];
	}
	
	public boolean isButtonDown(int buttonCode) {
		return buttons[buttonCode] && !buttonsLast[buttonCode];
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = (int) (e.getX());
		mouseY = (int) (e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int) (e.getX());
		mouseY = (int) (e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public int getScroll() {
		return scroll;
	}
}
