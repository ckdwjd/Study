package com.kh.chapter06_method.controller;

public class MethodTest2 {
	static int count = 0;
	int count2 = 0;
	/*
	 * static 메서드
	 * [표현법]
	 * 접근제한자 static 예약어 반환형 메소드명(매개변수) {
	 * 		수행내용
	 * 		return;
	 * }
	 * 
	 * - 호출 시 객체 생성할 필요가 없음
	 * - 프로그램 시작시에 정적메모리 영역(static 영역)에 메소드가 저장되어 있기 때문이다
	 * - 클래스명.메서드명(전달값); 으로 호출하면 된다
	 * - 예약어, 매개변수, return 구문(반환형이 없는 경우)는 생략 가능 
	 */
	
	public static void method1() {
		System.out.println("매개변수와 반환값이 없는 메서드");
	}
	
	public static String method2() {
		return "매개변수는 없지만 반환값은 있는 메서드";
	}
	
	public static void method3(String name, int age) {
		System.out.println(age + "살의 " + name + "님 반갑습니다.");
	}
	
	public static int method4(int num1, char op) {
		// num1과 필드에 있는 count, count2와 연산
		
		/*
		 * static 메서드안에서는 static이 아닌 필드 맴버가 접근 불가능
		 * 스태틱메서드는 프로그램 시작 시에 정적메모리 영역에 들어가는데
		 * 이때 스태틱으로 선언된 필드(전역변수)도 함께 정적메모리 영역에 들어갈 것
		 * 따라서 같은 범위 안에 있으니 사용이 가능
		 * 그러나, 스태틱으로 선언되지 않은 전역변수는 스태틱메모리에 올라가는 시점에 생성이 되지 않았으므로
		 * 사용이 불가능하기 때문에 에러 발생
		 */
		return num1 * count;  // 프로그램이 시작될 때 static 영역에 할당되기 때문에 접근 가능
		//return num1 * count2;  // count2는 스테틱메모리 영역에 없음
	}
}
