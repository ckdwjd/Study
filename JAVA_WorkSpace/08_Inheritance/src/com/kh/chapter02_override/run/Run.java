package com.kh.chapter02_override.run;

import com.kh.chapter02_override.model.vo.Book;

public class Run {

	public static void main(String[] args) {
		
		/*
		 * 모든 클래스 Object클래스의 후손 즉, 최상위 클래스는 항상 Object클래스
		 * => 즉,Object에 있는 메서드들을 오버라이딩을 통해 재정의 할 수 있음
		 */
		
		Book bk = new Book("자바프로그래밍 입문","창정",10000);
		
		/*
		 * 출력문 안에 참조 변수를 제시해서 출력하고자 할 때
		 * 내부적으로 JVM이 자동으로 toString()메서드를 호출
		 * 
		 * 부모클래스인 Object클래스에 있는 toString()함수가 항상 호출되었음
		 * 해당 클래스의 풀클래스명 + @ + 해당 객체의 주소값의 16진수
		 * 
		 * 자식클래스인 Book클래스에서 toString()메서드를 재정의
		 * 해당 객체의 모든 필드값을 하나의 문자열로 합쳐서 돌려주는 메서드로 변경함(자동생성)
		 * 
		 * 
		 */
		System.out.println(bk);
		
	}

}
