package com.kh.chapter06_method.controller;

public class OverloadingTest {
	/* 메서드 오버로딩
	 * - 한 클래스 내에 같은 메소드 명으로 정의할 수 있는 방법
	 * - 매개변수의 자료형의 개수, 순서가 다르게 작성되어야만 함
	 * - 단, 매개변수명, 접근제한자, 반환형은 메서드 오버로딩에 영향을 주지 않는다
	 */
	
	public void test() {
		
		// 메서드 오버로딩이 잘 되어있는 대표적인 메서드
		//System.out.println();
	}
	
	public void test(int a) {   // 매개변수 이름이 다르다고 해서 새로운 매서드가 생성되는 것은 아님
		
	}
	
	public void test(double a) {   
	}
	
	public void test(int a, String s) {
		
	}

	public void test(String s, int a) {  // 매개변수의 순서가 다르면 다른 매서드
		
	}
	
	public void test(int a, int b) {   // 자료형이 다르면 다른 메서드
		
	}
	
	// 매개변수명과는 상관없이 자료형의 갯수와 순서가 같아서 에러가 발생
	// 즉, 매개변수의 자료형의 개수와 순서가 다르게 작성되어야 함
//	public void test(int c, int d) {
//		
//	}
	
	// - 반환형이 다르다고 오버로딩이 적용되지 않는다
	// - 메서드를 호출하는 시점에 매개변수가 동일하기 때문에 에러발생
	// 즉, 반환형과 상관없이 매개변수의 자료형의 개수와 순서가 다르게 작성
//	public int test(int a, int b) {
//		
//	}
	
	// - 접근제한자가 다르다고 오버로딩이 적용되지 않기 때문에 에러 발생
	// 즉, 접근제한자와 상관없이 "매개변수"의 자료형의 개수 및 순서가 다르게 작성
//	private void test(int a, int b) { // 자료형이 다르면 다른 메서드
//
//	}
	
	
	
	
}
