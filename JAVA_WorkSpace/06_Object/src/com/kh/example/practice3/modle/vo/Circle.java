package com.kh.example.practice3.modle.vo;

public class Circle {
	// 대문자 : 상수(final)
	// 밑줄 : static
	
	private final static double PI = 3.14;
	private static int radius = 1;
	
	public Circle() {
		getAreaOfCircle();
		getSizeOfCircle();
		
		incrementRadius();
		
		getAreaOfCircle();
		getSizeOfCircle();
	}
	public void incrementRadius() {
		radius++;
	}
	public void getAreaOfCircle() {
		System.out.println("원의 넓이 : " + radius * radius * PI);
	}
	public void getSizeOfCircle() {
		System.out.println("원의 둘레 : " + (2 * PI * radius));
	}
}
