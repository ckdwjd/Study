package com.kh.chapter01.condition;

import java.util.Scanner;

public class C_Switch {
	
	/*
	 * Switch문은 if문과 동일한 조건문 중에 하나
	 * switch문과 if문의 차이점
	 * 
	 * if(조건식) = > 조건식을 복잡하게 기술가능. 비교범위(대소비교) 제시할 수 있음
	 * switch 조건식x => 확실한 값만 조건으로 기술할 수 있음, 이 값을 가지고 (동등비교만 수행함)
	 * 
	 * [표현법]
	 * switch(동등비교를 수행할 값) {
	 * case 값1 : 실행할 코드1;  //	앞으로 동등비교를 할 대상자 == 값1 일 경우 실행할 코드1을 실행함.
	 * 				break;  //실행할 코드 1을 실행하고 switch문을 빠져나갈 수 있게 break;를 걸어줌
	 * 						//break;문이 없다면 아래 내용이 순차적으로 실행
	 * case 값2 : 실행할 코드2;
	 * 				break;
	 * case 값n : 실행할 코드n;
	 * 				break;
	 * default : 실행할 코드;  //if - else if문에서 else문과 같은 역할을 함
	 * 						//위의 값1, 값2, ... 값n까지 앞으로 동등비교를 할 대상자와 일치하지 않다면
	 * 						//default 내의 실행할 코드가 실행됨
	 *						//마지막은 break문을 작성하지 않음
	 *
	 * switch문의 장점 : case에 기록된 값을 통해 내가 원하는 코드 위치로 프리패스 가능
	 * 					if - else문의 경우 if의 조건식 결과가 true가 나오기 전까지 조건식검사를 계속 실행하므로
	 * 					switch문보다 연산효율이 떨어짐
	 * 
	 * switch문 자주 사용되지 않지만, 사용하는 경우 정말 어떤 동일한 연산결과가 수행되어야 하는 경우
	 * ex) 키보드 입력, 마우스 입력
	 * 키보드 a를 누르는 입력시간과 p를 누를 때의 입력시간이 다르면 이상함 -> 게임을 할 경우 입력속도가 다름
	 */
	
	public void method1() {
		//1~3사이의 정수값을 입력받아
		//1인경우 "빨간불입니다"출력
		//2인경우 "파란불입니다"출력
		//3인경우 "초록불입니다"출력
		//잘못입력한 경우 "잘못 입력했습니다."출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1 ~ 3 사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
//		if(num == 1) {	//조건검사 1번
//			System.out.println("빨간불입니다");
//		} else if (num == 2) {	//조건검사 2번
//			System.out.println("파란불입니다");
//		} else if (num == 3) {	//조건검사 3번
//			System.out.println("초록불입니다");
//		} else {	//조건검사 3번
//			System.out.println("잘못 입력했습니다.");
//		}
		
		switch(num) {
		case 1 :
			System.out.println("빨간불입니다"); 
			break;
		case 2 :
			System.out.println("파란불입니다"); 
			break;
		case 3 :
			System.out.println("초록불입니다"); 
			break;
		default :
			System.out.println("잘못 입력했습니다"); 
		}
		
	}
	
	public void method2() {
		//사용자에게 구매할 과일명을 입력받아
		//각 과일마다 가격을 출력해보는 프로그램만들기
		
		//사과 : 1000원, 바나나 : 2000원, 복숭아 : 5000원
		
		//존재하는 과일인 경우.
		//xx의 가격은 xxxx원 입니다.
		
		//존재하지 않는 과일인 경우.
		//판매하지 않는 과일의 경우 : "저희 가게에서 판매하는 과일이 아닙니다."
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구매할 과일 목록(사과, 바나나, 복숭아)");
		System.out.print("구매하실 과일을 입력해주세요 : ");
		String fruit = sc.nextLine();
		
		int price = 0;
		
		switch(fruit) {
		case "사과":
			price = 1000;
			break;
		case "바나나":
			price = 2000;
			break;
		case "복숭아":
			price = 5000;
			break;
		default:
			System.out.println("저희 가게에서 판매하는 과일이 아닙니다.");
			return; // 아래 출력문이 안 나오게끔 return문 추가	
		}
		System.out.printf("%s의 가격은 %d원 입니다.",fruit ,price);
		
	}
	public void method3() {
		//사용자에게 등급별로 권한을 부여하는 프로그램
		//1등급 : 관리권한, 글쓰기 권한, 읽기 권한
		//2등급 : 글쓰기 권한, 읽기 권한
		//3등급 : 읽기 권한
		
		Scanner sc = new Scanner(System.in);
		System.out.print("등급을 입력하세요 : ");
		int level = sc.nextInt();
		
		//break문 없이 switch문을 작성하는 케이스가 종종 있음
		switch(level) {
		case 1 :
			System.out.print("관리 권한 소유, ");
		case 2 :
			System.out.print("글쓰기 권한 소유, ");
		case 3 :
			System.out.print("읽기 권한 소유");
			break;
		default:
			System.out.println("잘못 입력했습니다.");
		}
	}
	
	public void method4() {
		//사용자에게 1월 ~ 12월 사이의 월을 입력받아 해당 달의 마지막 날짜를 출력하는 프로그램
		// 1,3,5,7,8,10,12 -> 해당 달은 31일까지 입니다
		// 2 -> 해당 달은 28일까지 입니다
		// 4,6,9,11 -> 해당 달은 30일까지 입니다
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1월 ~ 12월 사이의 월을 입력해주세요 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 : 
		case 3 : 
		case 5 : 
		case 7 : 
		case 8 : 
		case 10 : 
		case 12 : 
			System.out.println("해당 달은 31일까지 입니다.");
			break;
		case 2 : 
			System.out.println("해당 달은 28일까지 입니다.");
			break;
		case 4 : 
		case 6 : 
		case 9 : 
		case 11 : 
			System.out.println("해당 달은 30일까지 입니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
		
	}
	
	
}