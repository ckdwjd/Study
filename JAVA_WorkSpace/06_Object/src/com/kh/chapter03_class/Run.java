package com.kh.chapter03_class;

import com.kh.chapter03_class.model.vo.Person;
import com.kh.chapter03_class.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		
		// Person이라는 클래스 == 나만의 자료형(여러개의 자료형의 여러개의 값들을 보관) == 사용자 정의 자료형
		Person p = new Person();
		
		System.out.println(p);  // toString 출력
		
		p.setMemberId("id");
		p.setMemberPwd("pass");
		p.setMemberName("창정");
		
		System.out.println(p);
		
		//상품객체 생성
		Product p1 = new Product();
		Product p2 = new Product();
		
		//상품객체에 상품명 아이폰14로 초기화
		p1.setpName("아이폰14");
		//상품객체의 가격을 1500000원으로 초기
		p1.setPrice(1500000);
		//브랜드 : 애플
		p1.setBrand("애플");

		//상품객체에 상품명 갤럭시z-plip4로 초기화
		p2.setpName("갤럭시z-plip4");
		//상품객체의 가격을 1000000원으로 초기
		p2.setPrice(1000000);
		//브랜드 : 삼성
		p2.setBrand("삼성");
		
		System.out.println(p1);
		System.out.println(p2);
		
		
	}

}
