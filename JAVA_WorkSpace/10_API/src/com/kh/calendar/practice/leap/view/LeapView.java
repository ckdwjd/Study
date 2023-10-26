package com.kh.calendar.practice.leap.view;

import java.util.Calendar;

import com.kh.calendar.practice.leap.controller.LeapController;

public class LeapView {

	public LeapView() {
		LeapController lc = new LeapController();
		
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		
		if(lc.isLeapYear(nowYear)) {
			System.out.println(nowYear + "년은 윤년입니다.");
		} else {
			System.out.println(nowYear + "년은 평년입니다.");
		}
		System.out.println("총 날짜 수 : " + lc.leapDate(now));
	}
}
