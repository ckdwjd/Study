package com.kh.chapter06_method;

import com.kh.chapter06_method.controller.MethodTest1;
import com.kh.chapter06_method.controller.MethodTest2;

public class Run {

	public static void main(String[] args) {
		System.out.println("==============================================");
		
		MethodTest1 mt1 = new MethodTest1();
		mt1.method1();
		
		int a = mt1.method2();  // 매개변수가 없는 메서드에 매개변수를 입력하면 에러 발생
		System.out.println("랜덤값은 ?? : " + a);
		
		mt1.method3(10, 5); // 반드시 자료형을 맞춰서 매개변수에 대입해야함
		
		System.out.println(mt1.method4(5, 55)); // 매개변수 자료형과 갯수를 맞춰서 대입
		
		MethodTest1 mt2 = new MethodTest1();  // 재사용 가능
		//mt2.method1();
		
		System.out.println("==============================================");
		// static 메서드의 경우에는 new생성자 구문으로 객체를 생성할 필요가 없다
		// static이 붙은 클래스 변수와 마찬가지로 메서드 또한 프로그램 실행 시에 정적메모리 영역에 저장
		// 클래스명.필드명 == static영역의 주소값
		// 클래스명.메서드명() == static영역의 주소값()
		MethodTest2.method1();
		// 매개변수와 반환값이 없는 메서드
		
		System.out.println(MethodTest2.method2());
		// 매개변수는 없지만 반환값은 있는 메서드
		
		MethodTest2.method3("오창정",25);
		// 25살의 오창정님 반갑습니다.
		
		MethodTest2.method4(1, '+');
		
	}

}
