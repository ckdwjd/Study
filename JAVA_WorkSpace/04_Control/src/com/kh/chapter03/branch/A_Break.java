package com.kh.chapter03.branch;

import java.util.Scanner;

public class A_Break {
	
	Scanner sc = new Scanner(System.in);

	/*
	 * break : break문을 만나는 순간 현재 속해있는 반복문 중 가장 가까운 반복문을 빠져나가는 구문
	 * 			즉, 해당 break문이 속해있는 반복문만 빠져나감
	 * 
	 * 주의할 점: switch문의 break와는 다른 개념
	 * 			switch문 안의 break는 switch문만을 빠져나가는 용도로 사용됨
	 */
	public void method1() {
		//매번 반복적으로 새로이 발생되는 랜덤값(1~100) 출력
		//단, 그 랜덤값이 3의 배수일 경우 반복문을 빠져나가게 설정
		//random : xxx
		
		for(;;) {
			int random = (int)((Math.random() * 100) + 1);
			System.out.println("random : " + random);
			
			if(random % 3 == 0) {
				break;
			}
		}
		System.out.println("==============");
		
		while(true) {
			int random = (int)(Math.random() * 100 + 1);
			System.out.println("random : " + random);
			
			if(random % 3 == 0) {
				break;
			}
		}
	}
	
	public void method2() {
		// 매번 사용자에게 문자열을 입력받은 후 해당 문자열의 길이를 출력
		//단, 사용자가 입력한 문자열이 "exit"라는 문자열과 일치한다면 반복을 종료
		
		while(true) {
			System.out.print("문자열 입력 : ");
			String str = sc.nextLine();
			
			if(str.equals("exit")){  //사용자가 입력한 문자열이 exit일 경우 반복문을 빠져나가게끔 조건 설정
				break;
			}
			// xxx의 글자수 : xx
			System.out.println(str + "의 글자수(길이) : " + str.length());
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void method3() {
		//매번 반복적으로 사용자에게 양수를 입력받아 1부터 사용자가 입력한 수까지 출력
		//단, 정상적으로 양수를 입력했을 경우 1부터 사용자가 입력한 수까지 출력을 한 후 종료
		//	 정상적으로 입력하지 않은 경우 "잘못 입력했습니다. 다시 입력해주세요."출력 후 다시 반복
		
		while (true) {
			System.out.print("양수 입력 : ");
			int num = sc.nextInt();

			if (num > 0) {
				for (int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				break;
			}
			System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
		}
	}
		
	
	
	
	
	
	
	
	
	
		
		
		
		
		
}
