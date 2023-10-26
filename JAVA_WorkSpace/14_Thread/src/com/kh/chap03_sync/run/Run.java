package com.kh.chap03_sync.run;

import com.kh.chap03_sync.sync.ATM;
import com.kh.chap03_sync.sync.Account;

public class Run {

	public static void main(String[] args) {

		Account acc = new Account(); // 모든 스레드에서 접근해서 사용할 공유자원
		
		Thread atm1 = new Thread(new ATM(acc), "atm1"); // (Runnable 인터페이스 구현객체, 스레드의 이름)
		
		Runnable run1 = new ATM(acc);
		Thread atm2 = new Thread(run1);
		atm2.setName("atm2");
		// atm1 == atm2 와 동일함

		atm1.start();
		atm2.start();
		/*
		 * 하나의 공유자원(Account)에 동시에 여러개의 스레드가(ATM1, ATM2)가 접근하는 상황을 경쟁상태라고 함
		 * 이를 방지하기 위해 하나의 공유자원에 접근할 때 하나의 스레드만 접근할 수 있도록 "통제"해야함
		 * 통제가 필요한 영역(임계 영역, 임계영역을 통제하기 위해 "synchronized" 키워드를 추가해야함)
		 * 
		 * 해결방법
		 * 1. synchronized 키워드 붙인 메서드 추가
		 * 2. 메서드 안에 synchronized 키워드 추가
		 */
		
		System.out.println("메인스레드 종료");
		
		
	}

}
