package com.kh.controller;

public class C_CustomException extends RuntimeException{

	/*
	 * 특정 상황에서 발생하는 에러를 직접 만들어서 사용해야할 때 사용
	 * 
	 * 나만의 에러를 만드는 방법
	 * 
	 * 1. 예외처리 클래스 만든 후 Exception클래스를 상속 받음
	 * 2. super키워드를 통해 부모생성자 매개변수로 전달받은 message값을 전달
	 * 3. 부모생성자에서 message내용을 호출하면서 예외처리
	 * 
	 */
	public C_CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public C_CustomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public void method1() {
		
	}
	
}
