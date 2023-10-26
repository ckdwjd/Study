package com.kh.practice1.func;

import java.util.Scanner;

public class VariablePractice1 {
	
	public void scannerTest1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요. : ");
		String name = sc.nextLine();
		
		System.out.print("성별을 입력하세요.(남/여) : ");
		char gender = sc.nextLine().charAt(0);
		
		System.out.print("나이를 입력하세요. : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("키를 입력하세요.(cm) : ");
		double height = sc.nextDouble();
		
		System.out.println("키 " + height + "cm인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다. ^^");
		
		
		System.out.printf("키 %.1fcm인 %d살 %c자 %s님 반갑습니다. ^^", height, age, gender, name);
	}
	
	public void ScannerTest2() {
		
		Scanner sc2 = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int fd = sc2.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int sd = sc2.nextInt();
		
		System.out.println("더하기 결과 : " + (fd + sd));
		System.out.println("빼기 결과 : " + (fd - sd));
		System.out.println("곱하기 결과 : " + fd * sd);
		System.out.println("나누기 몫 결과 : " + fd / sd);
		
		System.out.println("============");
		
		System.out.printf("더하기 결과 : %d\n빼기 결과 : %d\n곱하기 결과 : %d\n나누기 몫 결과 : %d\n", (fd + sd), (fd - sd), (fd * sd), (fd / sd) );
	}
	
	public void ScannerTest3() {
		
		Scanner sc3 = new Scanner(System.in);
		
		System.out.print("가로 : ");
		double x = sc3.nextDouble();
		
		System.out.print("세로 : ");
		double y = sc3.nextDouble();
		
		System.out.printf("면적 : %.2f\n둘레 : %.1f\n", x*y, 2*(x+y));
	}
	
	public void ScannerTest4() {
		
		Scanner sc4 = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc4.nextLine();
		
				
		System.out.println("첫 번째 문자 : " + str.charAt(0));
		System.out.println("두 번째 문자 : " + str.charAt(1));
		System.out.println("세 번째 문자 : " + str.charAt(2));
		
	}
	
	
	
	
	
}
