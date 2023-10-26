package com.kh.chapter05_constructor;

import com.kh.chapter05_constructor.model.vo.User;

public class Run {

	public static void main(String[] args) {

		// 1. 기본 생성자로 객체 생성
		User u1 = new User();
		u1.setUserId("user01");
		u1.setUserPwd("pass01");
		u1.setUserName("경민");

		System.out.println(u1);
		
		// 2. 객체 생성과 동시에 각 필드에 값들을 초기화
		User u2 = new User("user02" , "pass02","경민02");
		
		System.out.println(u2);
		
		// 3. 생성자는 여러개 만들 수 있음. 단, 매개변수가 중복되지 않아야 한다
		// 객체 생성과 동시에 각 필드에 값들을 초기화
		// 매개변수가 5개짜리 생성자로 객체 생성
		User u3 = new User("user03" , "pass03" , "경민03" , 33 , '남');
	
		System.out.println(u3);
		
		
		
		
		
		
		
		
	}

}

