package com.kh.chaper01_beforeVsAfter.after.run;

import com.kh.chaper01_beforeVsAfter.after.model.vo.Desktop;
import com.kh.chaper01_beforeVsAfter.after.model.vo.SmartPhone;
import com.kh.chaper01_beforeVsAfter.after.model.vo.Tv;

public class Run {

	public static void main(String[] args) {

		Desktop d = new Desktop("삼성", "d-01", "데탑", 2000000, true);
		
		SmartPhone s = new SmartPhone("애플", "a-01", "아이폰14", 1400000, "KT");

		Tv t = new Tv("엘지", "t-01", "얇은티비", 3500000, 60);
		
		System.out.println(d.toString());
		
		/*
		 * 상속의 장점
		 * - 보다 적은 양의 코드로 새로운 클래스들을 작성 가능
		 * - 중복된 코드를 공통적으로 관리하기 때문에 새로운 코드를 추가하거나 수정할 때 용이함
		 * 		=> 프로그램 생산성과 유지보수에 크게 기여
		 * - 정의해둔 부모 클래스를 통해 보다 손쉽게 다른 클래스로 확장이 가능
		 * 		ex) Product클래스 하나로 백화점에 존재하는 모든 상품객체를 만들 때
		 * 			데스크탑, 스마트폰, 티비 외에도 냉장고, 에어프라이어, 책 등 다양한 상품클래스로 확장시킬 수 있음
		 * 
		 * 상속의 특징
		 * - 클래스간의 다중상속은 불가능(단일 상속만 가능)
		 * - 명시되어 있진 않지만 모든 클래스(자바에서 이미 제공하는 클래스, 만든 클래스)는 Object클래스의 후손
		 * => Object클래스에 있는 메소드를 쓸 수 있음
		 * => Object클래스에 있는 메소드를 오버라이딩을 통해 재정의 가능
		 */
		
		
		
	}
	
	
	
	
	
	
	
	

}
