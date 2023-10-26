package com.kh.calendar.practice;

import java.util.Calendar;
import java.util.Scanner;

public class CalcDday {

	/*
	 * 
	 * Calendar클래스를 이용해서 D-Day 계산기 만들기
	 * 사용자로부터 D-Day를 입력받고, 다음과 같이 출력
	 * 1. (D-Day 전) : xxx일 남았습니다.
	 * 2. (D-Day) : D-Day입니다
	 * 3. (D-Day 후) : xxx일 지났습니다. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("D-Day를 입력해주세요.");
		System.out.print("년 : ");
		int year = sc.nextInt();
		
		System.out.print("월 : ");
		int month= sc.nextInt();
		
		System.out.print("일 : ");
		int date = sc.nextInt();
		
		Calendar dDay = Calendar.getInstance();
		dDay.set(year, month - 1, date,0,0,0);
		
		Calendar now = Calendar.getInstance();
		now.set(Calendar.MILLISECOND, 0);
		
		long diff = (now.getTimeInMillis() - dDay.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		
		if(diff < 0) {
			System.out.println(Math.abs((int)diff) + "일 남았습니다.");
		} else if(diff == 0) {
			System.out.println("D-Day입니다.");
		} else {
			System.out.println((int)diff + "일 지났습니다.");
		}
	}
}
