package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {

	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1당 사탕 개수 : " + candy / people);
		System.out.println("남은 사탕 개수 : " + candy % people);
		
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int classNum = sc.nextInt();
		
		System.out.print("번호(숫자만) : ");
		int id = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("성별(M/f) : ");
		char gender = sc.nextLine().charAt(0);
		String result = (gender == 'M' || gender == 'm') ? "남학생" : "여학생" ;
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", grade, classNum, id, name, result, score );
		
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String result = (age <= 13) ? "어린이" : (age > 19) ? "성인" : "청소년";
		
		System.out.println(result);
		
	}

	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민번호를 입력하세요(-포함) : ");
		String id = sc.nextLine();
		
		String result = (id.charAt(7) == '1' || id.charAt(7) == '3') ? "남자" : "여자";
		
		System.out.println(result);
	}
	
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		
		//단, num1은 num2보다 작아야 함
		String result = (num1 > num2) ? "잘못입력하셨습니다." : (num3 <= num1 || num3 > num2) ? "true" : "false";
		
		System.out.println(result);
		
	}
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("입력2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력3 : ");
		int num3 = sc.nextInt();
		
		String result = (num1 == num2 && num2 == num3) ? "true" : "false";
		
		System.out.println(result);
		
	}
	
	public void practice8() {
		
		Scanner sc = new Scanner(System.in);
		
		//A사원의 연봉 : 2500, 인센 : 0.4
		System.out.print("A사원의 연봉 : ");
		int pay1 = sc.nextInt();

		//B사원의 연봉 : 2900, 인센 : X
		System.out.print("B사원의 연봉 : ");
		int pay2 = sc.nextInt();
		
		//C사원의 연봉 : 2600, 인센 : 0.15
		System.out.print("C사원의 연봉 : ");
		int pay3 = sc.nextInt();
		
		double bonus1 = pay1 * 1.4;
		double bonus2 = pay2;
		double bonus3 = pay3 * 1.15;
		
		String result1 = (bonus1 > 3000) ? "3000 이상" : "3000 미만";
		String result2 = (bonus2 > 3000) ? "3000 이상" : "3000 미만";
		String result3 = (bonus3 > 3000) ? "3000 이상" : "3000 미만";
				
		System.out.printf("A사원 연봉/연봉+a : %d/%.1f \n%s \n", pay1, bonus1, result1);
		System.out.printf("B사원 연봉/연봉+a : %d/%.1f \n%s \n", pay2, bonus2, result2);
		System.out.printf("C사원 연봉/연봉+a : %d/%.13f \n%s \n", pay3, bonus3, result3);
		
		
		
	}
	
	
	
	
	
	
	
	
}
