package com.kh.calendar.practice;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcYourDays {
	/*
	 * 사용자로부터 생일(년, 월, 일)을 입력 받고, 오늘이 태어난지 몇 일 되었는지 출력
	 * 출력 예시 : 오늘은 x번째 날입니다. 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("생년월일을 입력하세요.");
		System.out.print("년 : ");
		int yyyy = sc.nextInt();
		sc.nextLine();
		
		System.out.print("월 : ");
		int MM = sc.nextInt();
		sc.nextLine();
		
		System.out.print("일 : ");
		int dd = sc.nextInt();
		sc.nextLine();
		
		Calendar cal = new GregorianCalendar(yyyy, MM-1, dd,0,0,0);
		Calendar now = Calendar.getInstance();
		
		long num1 = now.getTimeInMillis();
		long num2 = cal.getTimeInMillis();
		
		long diff = (num1 - num2) / 1000 / 60 / 60 / 24;
		
		System.out.printf("오늘은 %d번째 날입니다.", diff+1);
	}
	
	
	
	
	
	
	
	
	
	
	

}
