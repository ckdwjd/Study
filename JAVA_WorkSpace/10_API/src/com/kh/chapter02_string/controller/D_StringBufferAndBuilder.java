package com.kh.chapter02_string.controller;

public class D_StringBufferAndBuilder {
	/*
	 * String은 불변 클래스
	 * StringBuffer & StringBuilder는 변하는 클래스
	 * 문자열 연산이 빈번하게 일어나는 알고리즘에서 메모리 이슈를 해결하기 위해 나온 클래스
	 * 
	 * 기본적으로 두 클래스는 100% 동일한 메서드를 가짐
	 * 차이점 : 예약어("동기화" 여부)
	 * 
	 * 추 후 배우게 될 Thread개념이 적용되어 있음
	 * StrinfBuffer는 멀티스레드 환경에서 유용
	 * StringBuilder는 단일스레드 환경에서 유용
	 * 
	 */

	public void method() {
		
		String str = "Hello";
		str += "World";
		// 주소값 2개 생성
		
		StringBuffer sb = new StringBuffer("Hello");
		sb.append("World");
		// 주소값 1개 생성
		
		StringBuilder sb2 = new StringBuilder("Hello");
		sb2.append("World,");
		// 주소값 1개 생성
		
		// 유용한 메서드 알아보기
		// 특정 위치 문자를 없애는 메서드
		sb2.deleteCharAt(sb2.length() - 1); // 배열의 길이 '-1'이 인덱스의 마지막번째 
		System.out.println(sb2); // HelloWorld, -> HelloWorld ( "," 삭제)
		
		System.out.println("o의 마지막 위치 ? : " + sb2.lastIndexOf("o")); // HelloWorld에서 o의 마지막 위치 ? : 6
		// Indexof() & laseIndexof() 
		
		// 0번 인덱스부터 마지막 인덱스까지 모든 문자를 삭제
		System.out.println(sb.delete(0, sb.length() - 1)); // d
		System.out.println(sb); // d
		System.out.println(sb.delete(0, sb.length())); // 다 지우고 싶음 마지막 인덱스 + 1을 해야함
		System.out.println(sb); 
	}
}
