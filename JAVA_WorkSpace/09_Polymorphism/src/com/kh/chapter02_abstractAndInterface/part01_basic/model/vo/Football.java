package com.kh.chapter02_abstractAndInterface.part01_basic.model.vo;

public class Football extends Sports{

	
	
//	@Override
//	public void rule() {
//		System.out.println("발로 공을 차서 골대에 넣어야한다.");
//	}
	@Override
	public void rule() {
		System.out.println("발로 공을 차서 골대에 넣어야한다.");
	}
	/*
	 * 몸통부가 존재하지 않는 미완성 메서드 == 추상메서드
	 * 몸통부가 없는 미완성메서드(추상메서드)를 정의하고자 한다면 abstract예약어를 사용해야한다
	 * 
	 * 미완성 메서드가 클래스 내부에 하나라도 포함되는 순간, 해당 클래스 또한 미완성된 클래스
	 * (추상클래스)가 되어버림
	 * 
	 * 따라서 클래스에도 abstract키워드를 작성해야함
	 */
}
