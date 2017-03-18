package com.znow.test;

public class Test2 {

	public static void main(String[] args) {
		Test2 test2 = new Test2();
		
		Test1 test1 = new Test1();
		
		test2.draw(300, 300, 50, 50, test1);
	}
	
	public void draw(int x, int y, int w, int h, Test1 test1) {
		test1.render(x, y, w, h);
	}
}
