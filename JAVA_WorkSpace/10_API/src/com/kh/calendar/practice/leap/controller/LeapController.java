package com.kh.calendar.practice.leap.controller;

import java.util.Calendar;

public class LeapController {
	
	public boolean isLeapYear(int year) {
		if((year % 4 == 0) && ((year % 100 != 0 || year % 400 == 0))){
			return true;
		}
		return false;
	}
	
	public long leapDate(Calendar c) {
		
		Calendar setDate = Calendar.getInstance();
		setDate.set(1, 0,1,0,0,0);
		setDate.set(Calendar.MILLISECOND, 0);
		
		Calendar now = Calendar.getInstance();
		now.set(setDate.get(Calendar.YEAR), 3, 12,0,0,0);
		now.set(Calendar.MILLISECOND, 0);
		

		// 2023 - 1 = 2022 * 365 // 738,030
		int total = 365*(c.get(Calendar.YEAR) - 1);
		
		for(int i = 0; i < c.get(Calendar.YEAR); i+=4) {
			if(i % 100 !=0 || i % 400 == 0) {
				total++;
			}
		}
		//이번년도의 일수 구하기 2023.01.01 ~ 1.01.01
		long diff = (now.getTimeInMillis() - setDate.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		total += diff;
		
		return total;
	}
}
