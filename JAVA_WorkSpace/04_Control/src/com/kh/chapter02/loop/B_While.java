package com.kh.chapter02.loop;

import java.util.Scanner;

public class B_While {
	/*
	 * while문
	 * [표현법]
	 * [초기식;] -> 생략가능
	 * while(조건식) {  //조건이 true인 경우 해당 구문들을 반복적으로 실행, 조건식 내용에 true를 적는다면 무한반복
	 * 		반복적으로 실행할 내용
	 * 		...
	 * 		[증감식;]  //필수는 아님
	 * }
	 * 
	 * for문과 다르게 초기식, 증감식이 필수는 아님
	 * 분기문에서 초기식, 증감식, 표현없이 작성하는 법을 배울 예정
	 */
	
	public void method1() {
		// for문을 while문으로, while문을 for문으로 표현하는 방법
		
//		for(int i = 0; i < 5; i++) {  //5회 반복
//			System.out.println("안녕하세요");
//		}
		
		int i = 0;  //초기식
		while(i < 5) {  //조건식
			System.out.println("안녕하세요");  // 반복적으로 실행할 내용
			i++;  //증감식
		}
	}

	public void method2() {
		//1 2 3 4 5
		int i = 1;
		while(i <= 5) {
			System.out.print(i++ + " "); //2줄 코드를 1줄 코드로 줄임
			//i++;
		}
	}
	
	public void method3() {
		//1 ~ 10사이의 홀수만 출력
		// 1 3 5 7 9
		//whil문 & for문으로 만들기
		
//		for(int i = 1; i <= 10; i +=2) {
//			System.out.print(i + " ");
//		}
		
		int i1 = 1;
		while(i1 <= 10) {
			System.out.print(i1 + " ");
			i1 += 2;
		}
		
		int i2 = 1;
		while(i2 <= 10) {
			if(i2 % 2 == 1) {
				System.out.print(i2 + " ");
			}
			i2++;
		}
	}
	
	public void method4() {
		//1부터 랜덤값(100사이)의 총 합계 구하기
		int random = (int)((Math.random() * 100) + 1);
		
		int sum = 0;
		int text_random = random;
		
//		int i = 1;
//		while(i <= random) {
//			sum += i++;
//		}
		while(random > 0) {
			sum += random--;
		}
		System.out.println("1부터 " + text_random + "까지의 총 합계 : " + sum);
	}
	
	/*
	 * do-while문
	 * [표현법]
	 * do { // 별도의 조건 검사 없이 무조건 1번은 실행시킴 => 즉, 조건이 맞지 않아도 한번은 수행
	 * 
	 * 		//실행할 코드
	 * } while(조건식);  / 조건검사 true면 -> 실행할 코드 실행 후 코드를 다시 실행하고, false면 반복문을 빠져나옴
	 * 
	 * for/while문과 do-while문의 차이점?
	 * for/while문은 처음 수행할 때도 조건검사 후 true여야 실행을 했지만
	 * do-while문은 첫 실행을 무조건 실행한다라는 특징이 있음
	 */
	
	public void method5() {
		// 애초에 조건이 맞지 않아도 한번은 수행됨
		int num = 1;
		
		do {
			System.out.println("안녕");
		}
		while(num == 0);
	}
	
	public void method6() {
		//1부터 사용자가 입력한 숫자까지의 총 합계
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		int i = 1;
		
		do {
			sum += i++;
		} while(i <= num);

		System.out.printf("1부터 사용자가 입력한 %d까지의 총 합계 : %d", num, sum);
	}
	
	
	
	
	
	
	
	
	
	
	
}
