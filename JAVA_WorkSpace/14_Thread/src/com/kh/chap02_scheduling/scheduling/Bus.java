package com.kh.chap02_scheduling.scheduling;

public class Bus implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0; i < 20; i++) {
			
			try {
				System.out.println("Bus drives...");
				
				Thread.sleep(100); // 스레드를 지정된 시간만큼 지연시키는 메서드(ms단위 : 100 => 0.1초)
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
