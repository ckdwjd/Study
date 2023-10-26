package com.kh.member.run;

import java.util.Calendar;
import java.util.StringTokenizer;

import com.kh.member.model.vo.Member;

public class Run {

	/*
	 * 
	 * 다음과 같이 회원정보를 하나의 문자열로 담았다. 각회원별 정보의 순서는 회원번호,이름,키,몸무게,생일(yyyyMMdd)이다.
	 * 
	 * "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319"
	 * 
	 * 각각의 회원정보를 분리해서, 회원객체에 담고, 회원객체배열에 추가한다.
	 * 
	 * 출력메소드를 통해 회원정보를 출력한다.
	 * 
	 * - 회원 com.api.member.model.vo.member - memberNo : int - memeberName : String -
	 * height : int - weight : int - birth : Calendar + information : String
	 * 
	 * 
	 */
	public static void main(String[] args) {
		String str = "1,김연아,165,47,19900905|2,양세형,167,60,19850818|3,김래원,182,80,19810319";
		
		// Member[] 선언
		Member[] memberArr = new Member[3];
		
		// 1. | 기준으로 분리
		StringTokenizer stn = new StringTokenizer(str,"|");
		
		int i = 0;
		while(stn.hasMoreTokens()) {
			// 2. , 기준으로 분리
			String[] s = stn.nextToken().split(",");
			// s[0] = "1";
			// s[1] = "김연아";
			// ...
			// s[4] = "19900905";
			
			// 2_1. 분리한 데이터를 Member객체 안에 넣기
			Member m = new Member();
			
			m.setMemberNo(Integer.parseInt(s[0]));
			m.setMemberName(s[1]);
			m.setHeight(Integer.parseInt(s[2]));
			m.setWeight(Integer.parseInt(s[3]));
			
			int year = Integer.parseInt(s[4].substring(0, 4));
			int month = Integer.parseInt(s[4].substring(4,6));
			int date = Integer.parseInt(s[4].substring(6));
			
			Calendar birth = Calendar.getInstance();
			birth.set(year, month, date);
			m.setBirth(birth);
			
			// 3. Member배열에 추가
			memberArr[i++] = m;
		}
		
		for(Member m : memberArr) {
			System.out.println(m);
		}
	}
}
