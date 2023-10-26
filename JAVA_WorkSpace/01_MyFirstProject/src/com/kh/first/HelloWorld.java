package com.kh.first;                                // 패키지 선언부
// 패키지 작성 시 2단계 까지는 도메인의 역순으로 작성함 
// ex) kh.com -> com.kh      naver.com -> com.naver



public class HelloWorld {                            // = HelloWorld 클래스 영역 시작부분
	
	// 한줄 짜리 주석
	
	/*
	 * 여러줄 짜리 주석 (ctrl + shift + /)
	 */
	
	//
	// 여러줄을 한줄짜리로 주석  (ctrl + shift + c)
	//
	
	// 모든 줄 정렬  전체 선택 후 (ctrl +shift + f)
	
	/*
	 * 
	 * 메인 메서드는 자바애플리케이션, 자바 프로그램 실행 시 시작되는 시작점(entry point)
	 * 
	 * 따라서 하나의 JAVA 애플리케이션에는 반드시 1개 이상의 main 메서드를 포함한 클래스가 있어야 함
	 * 
	 */
	
	
	public static void main(String[] args) {         // main 메서드의 틀
		
		System.out.println("HelloWorld");            // 출력문, 콘솔창 안에 ()안에 들어간 값을 출력하면서 다음줄로 넘어감;
	}
}
