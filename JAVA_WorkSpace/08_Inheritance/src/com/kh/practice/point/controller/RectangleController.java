package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {

	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r = new Rectangle(x, y, width, height);
		return "면적 : "  + x + "," + y + "," + height + "," + width + " / " + width * height;
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r = new Rectangle(x, y, width, height);
		return "둘레 : "  + x + "," + y + "," + height + "," + width + " / " + 2 * (width + height);
	}
}
