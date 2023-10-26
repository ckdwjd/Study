package com.kh.calendar.practice.token.controller;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		
	}
	
	public String afterToken(String str) {
		String str2 = "";
		StringTokenizer stn = new StringTokenizer(str, " ");
		//StringBuilder sb = new StringBuilder("");
		while(stn.hasMoreTokens()) {
			str2 += stn.nextToken();
			//sb.append(stn.nextToken());
		}
		return str2;
		// str2로 반환시 메모리공간 활용이 떨어져서 StringBuilder를 이용해서 작성
	}
	
	public String firstCap(String input) {
		String str = input.toUpperCase().charAt(0) + input.substring(1);
		
		return str;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == one) {
				count += 1;
			}
		}
		return count;
	}
}
