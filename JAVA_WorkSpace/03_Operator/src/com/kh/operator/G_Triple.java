package com.kh.operator;

import java.util.Scanner;

public class G_Triple {
	/*
	 * 삼항연산자 : 3개의 항목(값)을 가지고 연산하는 연산자
	 *  
	 * [표현법]
	 * 조건식 ? 조건이 true일 경우 : 조건이 false인 경우
	 * 
	 * 조건식이란(true/false)가 나오게하는 연산자(주로 논리연산자를 통해 작성)
	 * 
	 */
	
	public void method1() {

		//사용자가 입력한 정수값이 양수인지 아닌지 판별 후 그에 맞는 결과 값을 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();
		
		//결과값이 String이기 때문에 String변수를 사용
		String result = (num > 0) ? "양수입니다." : "음수입니다.";
		
		//xx 는 xxxx.
		
		System.out.println(num + "는 " + result);
		System.out.println(num + "는 " + ((num > 0) ? "양수입니다." : "음수입니다.")); 
		
	}
	
	public void method2() {
		
		//사용자가 입력한 정수값이 짝수인지 홀수인지 판별 후 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요. : ");
		
		int num = sc.nextInt();
		String result = (num % 2 == 0) ? "짝" : "음";
		
		//x은(는) x수 입니다
		System.out.println(num + "는 " + result);
		System.out.printf("%d은(는) %s수입니다." , num, result);
		
	}
	
	public void method3() {
		
		//사용자로부터 종료의사여부를 입력받은 후 판별해서 출력
		//사용자가 입력한 값이 y이거나 Y인 경우 => 프로그램을 종료합니다.
		//				  	그 외의 경우  => 계속 진행합니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("종료하시려면 y(Y)를 입력하세요. : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = (ch == 'Y' || ch == 'y') ? "프로그램을 종료합니다." : "계속 진행합니다.";
		
		System.out.println(result);
		
	}
	
	public void method4() {
		
		//입력받은 값이 영어 소문자인지 대문자인지 판별 후 출력
		Scanner sc = new Scanner(System.in);
		
		//영문자 입력 : 
		System.out.print("영어를 입력하세요. : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = ((ch >= 65) && (ch <= 90)) ? "대문자입니다." : "소문자입니다.";
		String result2 = ((ch >= 'A') && (ch <= 'Z')) ? "대문자입니다." : ((ch >= 'a') && (ch <= 'z')) ? "소문자입니다." : "잘못 입력했습니다.";
		
		//출력문 형식 : 소문자입니다. 대문자입니다.
		System.out.println("입력하신 영어의 첫 글자는 "+ ch + "이고 " + result);
		System.out.printf("입력하신 영어의 첫 글자는 %c이고 %s", ch, result2);
		
	}
	
	//삼항연산자 중첩사용해보기
	public void method5() {
		
		// 사용자가 입력한 정수값이 양수인지 아닌지 판별 후 그에 맞는 결과 값을 출력
		Scanner sc = new Scanner(System.in);

		System.out.print("정수값 입력 : ");
		int num = sc.nextInt();

		// 결과값이 String이기 때문에 String변수를 사용
		String result = (num > 0) ? "양수입니다." : (num < 0) ? "음수입니다." : "0입니다."; 
		// 사용자가 입력한 값이 양수인지, 음수인지, 0인지 정확하게 판별 후 그에 맞는 결과를 출력

		// xx 는 xxxx.

		System.out.println(num + "는 " + result);

	}
	
	public void method6() {
		/*
		 * 	두개의 정수값과 + 또는 - 의 문자를 하나 입력받아
		 * +일 경우 두 정수 값의 덧셈 연산한 결과
		 * -일 경우 두 정수 값의 뺄샘 연산한 결과
		 * 둘 다 아닐경우"잘못 입력했습니다"를 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		//첫 번째 정수 :
		System.out.print("첫 번째 정수를 입력하세요 :");
		int num1 = sc.nextInt();
		
		sc.nextLine();
		
		//두 번째 정수 :
		System.out.print("두 번째 정수를 입력하세요 :");
		int num2 = sc.nextInt();
		
		sc.nextLine(); //엔터키 비워주기
		
		//연산자 입력(+ or -) :
		System.out.print("연산자를 입력하세요 :");
		char ch = sc.next().charAt(0);
		
		//결과 : xxx
		String result = (ch == '+') ? (num1 + num2) + "" : (ch == '-') ? (num1 - num2) + "" : "잘못입력했습니다";  
		//정수값은 문자열이 될 수 없기 때문에 문자열 ""을 붙여준다.
		
		System.out.println("결과는 : " + result);
		
	}
	
	
	
	
	
	
}
