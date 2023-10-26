package com.kh.controller;

import java.util.Scanner;

public class A_UncheckedException {

	/*
	 * RuntimeException
	 * - 프로그램 실행 시 발생되는 예외들
	 * 
	 * RuntimeException의 자식 클래스들
	 * - ArrayIndexOutOfBoundException : 특정 배열에 부적절한 인덱스로 접근했을 때 발생하는 예외
	 * - NullPointerException : 참조변수가 담고있는 값이 NULL임에도 불구하고 어딘가에 접근하려고 했을 때 발생하는 예외
	 * - ArithmeticException : 나누기 연산 시 0으로 나눌 때 발생하는 예외
	 * - ClassCastException : 강제적 형변환을 할 때 허용하지 않는 형변환일 때 발생하는 예외
	 * - NegativeArraySizeException : 배열의 크기를 음수로 지정할 경우 발생하는 예외
	 * 
	 * => 이러한 RuntimeException과 관련한 예외는 충분히 예측 가능한 상황이기 떄문에 예외 자체가 발생이 안되게끔 조건문으로 해결 가능
	 * 	  굳이 예외처리(예외가 발생했을 떄 실행할 내용을 정의해두는 행위)를 할 필요가 없다
	 */
	
	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		// ArithmeticException : 나누기 연산시 0으로 나눴을 때 발생하는 예외
		
		// 사용자에게 두 개의 정수 값을 입력받아 나눗셈을 한 결과를 출력 예정
		System.out.print("첫 번째 정수 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int num2 = sc.nextInt();
		
		// 해결방법 1. 조건문으로 처리(예외가 발생할 수 없게 if문으로 조건 검사 후 계속 진행) => 예외처리 X
//		if(num2 != 0) {
//			System.out.println("나눗셈 연산 결과 : " + num1/num2);
//		} else {
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
		
		// 해결방법 2. 예외처리 구문으로 해결(예외가 발생했을 경우를 대비해서 실행할 내용을 정의해두는 것)
		/*
		 * try ~ catch문
		 * [표현법]
		 * try{
		 * 		// 예외가 발생될 수 있는 구문
		 * } catch(발생될 예외 클래스 변수명(매개변수)) {
		 * 		// 예외가 발생했을 경우 실행할 구문
		 * }
		 */
		try {
			System.out.println("나눗셈 연산 결과 : " + num1/num2);
		} catch(ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다.");
			e.printStackTrace(); // 오류 추적 구문(현재 예외가 발생한 정보를 볼 수 있음)
		}
		System.out.println("프로그램 종료");
	}
	
	public void method2() {
		
		// ArrayIndexOutOfBoundsException
		// NegativeArraySizeException
		
		System.out.print("배열의 크기를 지정 : ");
		int size = sc.nextInt();
		
//		if(size > 0) {
//			int[] arr = new int[size];
//		}
		
//		try {
//			int[] arr = new int[size]; // 에러 발생 시 try블럭 안의 아래내용은 실행되지 않음
//			System.out.println(arr[100]);
//		} catch(NegativeArraySizeException e) {		// 해당 catch블럭이 실행되면 try ~ catch블럭을 빠져나감
//			System.out.println("배열의 크기로는 음수를 제시할 수 없음");
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("부적절한 인덱스로 접근함");
//		}
		
		try {
			int[] arr = new int[size]; // 에러 발생 시 try블럭 안의 아래내용은 실행되지 않음
			System.out.println(arr[100]);
		} catch(RuntimeException e) {	// 다형성을 적용하여 부모타입 예외 클래스를 작성 가능
			System.out.println("예외 발생했는데, 배열의 크기를 음수로 지정했거나, 부적절한 인덱스로 접근했을 것");
			// 다중 catch블럭보다 예외는 적어졌지만 어떤 에러 발생인지 파악 불가능
		} /*catch(ArrayIndexOutOfBoundsException e) {
			// RuntimeException이 이미 앞서 실행되기 때문에 도달할 수 없기 때문
			// 다중 catch 작성 시 블럭의 순서가 중요함 => 범위가 작은 자식타입의 예외클래스를 먼저 기술해야함
		}*/
		System.out.println("프로그램 종료");
	}
	/*
	 * RuntimeException과 관련된 예외들은 조건문으로 해결이 가능
	 * 따라서, 예외 자체가 발생하지 않게 개발자가 소스코드로 핸들링 해야함(예외처리 X)
	 * - 예외처리 구문으로도 해결 가능 => 예외가 발생했을 때를 대비해서 그 떄 실행할 내용을 정의해두는 것
	 * 
	 * 예측이 가능한 상황 => 조건문으로 해결하는 것을 권장
	 * 예측이 불가능한 상황 => 예외처리 구문으로 해결
	 * 
	 * RuntimeException 계열은 충분히 예측 가능한 상황이기 때문에 => 조건문으로 해결하는 것을 권장
	 * 
	 * UncCheckedException => 필수는 아님
	 */
}