package com.kh.chaper01_beforeVsAfter.before.run;

import com.kh.chaper01_beforeVsAfter.before.model.vo.Desktop;
import com.kh.chaper01_beforeVsAfter.before.model.vo.SmartPhone;
import com.kh.chaper01_beforeVsAfter.before.model.vo.Tv;

public class Run {

	public static void main(String[] args) {
		// Desktop 객체
		Desktop d = new Desktop("삼성", "d-01","데탑",2000000,true);
		
		SmartPhone s = new SmartPhone("애플","a-01","아이폰14",1400000,"KT");
		
		Tv t = new Tv("엘지","t-01","얇은티비",3500000,60);
		
		System.out.println(d);
		System.out.println(s);
		System.out.println(t);
		
		/*
		 * 매 클래스마다 중복된 코드들을 일일이 기술하게되면 문제가 여러가지 있음
		 * 1. 수정과 같은 유지보수 시 매번 일일이 찾아서 수정해야하는 번거로움이 있다
		 * 		ex) 필드명 수정, 새로운 필드 추가, 필드 삭제
		 * 
		 * 상속이라는 개념을 적용시켜서 매 클래스마다 중복된 필드, 메서드들을 한번에 하나의 클래스로 정의해둔 후
		 * 해당 클래스를 상속받는 식으로 진행
		 * 
		 * 
		 */
	}
	
	
	
	
	
	
	
	
	
	
	

}
