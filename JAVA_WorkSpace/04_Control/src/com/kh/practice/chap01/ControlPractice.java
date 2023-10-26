package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {

	public void practice1() {

		Scanner sc = new Scanner(System.in);

		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");

		System.out.print("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();

		String result = "";

		switch (num) {
		case 1:
			result = "입력";
			break;
		case 2:
			result = "수정";
			break;
		case 3:
			result = "조회";
			break;
		case 4:
			result = "삭제";
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			return;
		default:
			System.out.println("다시한번 입력하세요");
		}

		System.out.println(result + " 메뉴 입니다.");

	}

	public void practice4() {

		Scanner sc = new Scanner(System.in);

		System.out.print("1 ~ 12 사이의 정수 입력 : ");
		int month = sc.nextInt();

		String season = "";

		switch (month) {
		case 1:
		case 2:
		case 12:
			season = "겨울";
			break;
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		default:
			System.out.println(month + "월은 잘못 입력된 달입니다.");
			return;
		}
		System.out.println(month + "월은 " + season + "입니다.");

	}

	public void practice5() {

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = sc.nextLine();

		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();

		if (id.equals("chang") && pw.equals("2717")) {
			System.out.println("로그인 성공");
		} else if (!pw.equals("2717")) {
			System.out.println("비밀번호가 틀렸습니다");
		} else if (!id.equals("chang")) {
			System.out.println("아이디가 틀렸습니다");
		}

	}

	public void practice7() {

		Scanner sc = new Scanner(System.in);

		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();

		double bmi = weight / (height * height);
		String result = "";

		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 23) {
			result = "정상체중";
		} else if (bmi < 25) {
			result = "과체중";
		} else if (bmi < 30) {
			result = "비만";
		} else {
			result = "고도 비만";
		}
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
	}

	public void practice8() {

		Scanner sc = new Scanner(System.in);

		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();

		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();

		sc.nextLine();
		
		if (!(num1 > 0 && num2 > 0)) {
			System.out.println("양수가 아닙니다. 프로그램을 종료합니다.");
			practice8();
			return;
		} 
		
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
		char op = sc.nextLine().charAt(0);

		double result = 0;
			
		if (op == '-') {
			result = num1 - (double)num2;
		} else if (op == '+') {
			result = num1 + (double)num2;
		} else if (op == '/') {
			result = num1 / (double)num2;
		} else if (op == '*') {
			result = num1 * (double)num2;
		} else if (op == '%') {
			result = num1 % (double)num2;
		} else {
			System.out.print("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			return;
		}
		
		System.out.printf("%d %c %d = %f",num1, op, num2, result);
		
	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int test1 = sc.nextInt();
		double t1 = test1 * 0.2;
		
		System.out.print("기말 고사 점수 : ");
		int test2 = sc.nextInt();
		double t2 = test2 * 0.3;
		
		System.out.print("과제 점수 : ");
		int homework = sc.nextInt();
		double hw = homework * 0.3;
		
		System.out.print("출석 회수 : ");
		int attend = sc.nextInt();
		double at = attend;
	
		double result = t1 + t2 + hw + at;
		
		String presult = "";
		
		System.out.println("========== 결과 ==========");
		if(attend > 20*0.7) {
			if(result >= 70) {
				System.out.println("중간 고사 점수(20) : " + t1);
				System.out.println("기말 고사 점수(30) : " + t2);
				System.out.println("과제 점수    (30) : " + hw);
				System.out.println("출석 점수    (20) : " + at);
				System.out.println("총점 : " + result);
				presult = "PASS";
			} else {
				presult = "Fail [기준 점수 미달]";
			}
		} else {
			presult = "Fail [출석 회수 부족 (" + attend + "/20)]";
		}
		
		System.out.println(presult);
		
	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		System.out.print("선택 : ");
		int botton = sc.nextInt();
		
		System.out.print("(실습문제" + botton + " 실행)");
		
	}
	

	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("비밀번호 입력(1000 ~ 9999) : ");
		int pw = sc.nextInt();
		
		String pW =pw+"";
		
		String result;
		
		char pw1 = pW.charAt(0);
		char pw2 = pW.charAt(1);
		char pw3 = pW.charAt(2);
		char pw4 = pW.charAt(3);
		
		if(pw > 9999 || pw < 999) {
			result = "자리수 안맞음";
		} else if(pw1 == pw2 || pw2 == pw3 || pw3 == pw4 || pw1 == pw3 || pw1 == pw4 || pw2 == pw4) {
			result = "실패";
		} else {
			result = "성공";
		}
		
		System.out.println(result);
	}
	
	public void practice11_1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 입력(1000 ~ 9999) : ");
		int num = sc.nextInt();
		
		int thousand = num / 1000;  //1234 -> 1 (1000의 자릿수)
		int hundred = (num % 1000) / 100;  // 1234 -> 234 ->2 (100의 자릿수)
		int ten = ((num % 1000) % 100) / 10; // 1234 -> 234 -> 34 -> 3 (10의 자릿수)
		int one = ((num % 1000) % 100) % 10; // 1234 -> 234 -> 34 -> 4 (1의 자릿수)
		
		if(num < 1000 || num > 9999) {
			System.out.println("자릿수 안맞음");
		} else if( !(one == ten || one == hundred || one == thousand || ten == hundred || ten == thousand || hundred == thousand)) {
			System.out.println("생성 성공");
		} else {
			System.out.println("중복 값 있음");
		}
	}
	
	
	
	
	
	
	
}
