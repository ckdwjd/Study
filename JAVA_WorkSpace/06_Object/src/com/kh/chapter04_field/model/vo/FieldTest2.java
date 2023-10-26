package com.kh.chapter04_field.model.vo;

// 클래스 변수(static 변수)와 상수필드(static final)에 대해
public class FieldTest2 {
	
	// 접근제한자 예약어(생략가능) 자료명 변수명;
	public static String sta = "static 변수";
	
	/*
	 * static은 '정적인, 고정된, 움직이지 않는'의 믜미를 가짐
	 * 즉, static키워드는 특정 변수나, 메서드를 메모리 영역(static)에 "고정"시킨다
	 * 
	 * 이렇게 static영역에 고정된 데이터는 모든 객체에서 "공유"할 수 있다
	 * 따라서 자주 사용하는 변수, 메서드를 static으로 선언함으로써 메모리 영역에 미리 올려두고
	 * 모든 객체에서 공유하면서 사용하게 됨
	 * 
	 * static 키워드 변수나 메서드
	 * Math.random();  // 클래스명.필드
	 */
	
	/*
	 * 상수필드
	 * 
	 * public static final 자료형 변수명 = 값;
	 * 한번 지정된 값을 고정해서 쓰기 때문에 무조건 초기화를 해야한다
	 * 
	 * 예약어 순서는 상관없음
	 * 
	 * static : 공유(재사용)
	 * final : 한번 지정된 값 변경(정수);
	 * 
	 * 값이 변경되어서는 안되는 고정적인 값을 메모리상에 올려두고 공유하면서 사용할 목적
	 * ex) Math.PI;
	 *
	 *상수명은 항상 모든 글자가 대문자여야함
	 */
	
	public static final int NUM = 10;
	
	public static void test() {
		System.out.println("Hello");
	}
	/*
	 * static필드 생성 시점 : 프로그램 실행과 동시에 메모리의 static영역에 할당됨(굳이 객체생성하지 않아도 됨)
	 * 		 	 소멸 시점 : 프로그램 종료시 소멸됨
	 * 따라서 프로그램의 생명주기와 동일한 생명주기를 가지게 되므로 static영역 안에 너무 많은 클래스 변수, 메서드를 추가하는 것이 좋지 못함
	 */
	
}
