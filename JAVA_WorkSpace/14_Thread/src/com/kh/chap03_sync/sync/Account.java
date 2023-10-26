package com.kh.chap03_sync.sync;
/*
 * 1. 계좌 1개의 계좌
 * 2. ATM 2개
 */
public class Account {
	
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	/*
	 * 동기화란?
	 * - 멀티스레드 프로그래밍에서 스레드간에 공유자원에 대한 처리를 말함(즉, 공유자원 사용 순서를 정해주는 개념)
	 * - 공유자원에 대한 LOCK을 획득한 스레드만 공유자원 사용이 가능
	 */
	
	// 출금 메서드
	// synchronized (격리공간으로 지정)
	// - 동기화 메서드, 동기화 블럭에 사용되는 키워드
	// - 동기화 메서드는 메서드 선언에 synchronized키워드를 붙이고 인스턴스, 정적 메서드 어디서든 사용이 가능
	// - 동기화 메서드는 스레드가 메서드를 실행하면 메서드 전체에 락을 걸고 메서드가 종료되면 락이 풀림 -> 메서드가 존재하는 객체 자체에 락
	// - 현재 메서드가 존재하는 객체가 아니라 다른 객체에 락을 걸고 싶다면 동기화 블럭을 사용(동기화 블럭 사용 권장)
	public /*synchronized*/ void withdraw(int money) {
		
		// 동기화 블럭 synchronized(공유객체) {}
		synchronized(this) {
			System.out.println(Thread.currentThread().getName() + ":::::" + balance);
			
			if(money <= balance) {
				balance -= money;
				System.out.printf("[%s] %d원 출금 >>> 잔액 : %d원\n",Thread.currentThread().getName(), money, balance);
			} else {
				System.out.printf("[%s] %d원 출금시도 >>> 잔액이 부족합니다. \n", Thread.currentThread().getName(), money);
			}
		}
	}
}
