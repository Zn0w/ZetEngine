package com.znow.zetengine;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.*;
import org.lwjgl.*;

import org.lwjgl.input.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Button {
	
	private int x, y, w, h;
	
	private ActionHandler handler;
	
	//private Texture texture;
	
	public Button(int sX, int sY, int sW, int sH, String imagePath) {
		x = sX;
		y = sY;
		w = sW;
		h = sH;
		
		/*File file = new File(imagePath);
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void draw() {
		glColor3f(1.0f, 1.0f, 1.0f);
		
		glBegin(GL_QUADS);
		//glTexCoord2f(0, 0);
		glVertex2f(x, y);
		//glTexCoord2f(1, 0);
		glVertex2f(x + w, y);
		//glTexCoord2f(1, 1);
		glVertex2f(x + w, y + h);
		//glTexCoord2f(0, 0);
		glVertex2f(x, y + h);
		glEnd();
	}
	
	public void update() {
		while (Mouse.next()) {
			if (Mouse.isButtonDown(0)) {
				int mX = Mouse.getX();
				int mY = Mouse.getY();
				
				if (mX >= x && mX <= x + w && mY >= y && mY <= y + h)
					handler.onAction();
			}
		}
		if (Mouse.isButtonDown(0)) {
			int mX = Mouse.getX();
			int mY = Mouse.getY();
			
			if (mX >= x && mX <= x + w && mY >= y && mY <= y + h)
				handler.onAction();
		}
	}
	
	public void setAction(ActionHandler sHandler) {
		handler = sHandler;
	}
	
}
