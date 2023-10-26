package com.kh.chap01_thread.thread;
/*
 * 스레드 생성 방법 1
 * 1. Thread클래스를 상속받는 방법(Thread클래스 내부의 모든 메서드를 가져와서 사용할 수 있음)
 * 		- Thread클래스 상속 후 run()메서드 오버라이딩 => 스레드가 실행시키는 코드 내용이 run메서드 안의 내용
 * 		- Thread1 객체 생성하고, start() 메서드 호출
 */
public class Thread1 extends Thread{
	// 스레드 실행 시(start() 호출 시) run()메서드가 자동으로 호출됨
	// 따라서 작업하고자 하는 코드를 반드시 run이라는 메서드 안에 작성을 해야함
	// 즉, Thread클래스 안에 있는 run메서드를 내가 원하는 형태로 재정의하면 된다
	
	@Override
	public void run() {
		// 작업하고자 하는 코드를 작성
		
		for(int i = 1; i <= 100; i++) {
			System.out.println(getName() + "[" + i + "]");
		}
	}
	
	
}
