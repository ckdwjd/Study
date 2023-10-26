package com.kh.chapter03.branch;

public class B_Continue {
	/*
	 * continue; : 반복문 안에서 사용하는 구문
	 * 				continue를 만나게 되면 그 뒤에 어떤 구문이 있든 간에 실행하지 않고
	 * 				가장 가까운 반복문으로 올라가라는걸 의미
	 */

	public void method1() {
		// 1 ~ 10까지 홀수만 출력
		// 1 3 5 7 9
		
		//방법1 : i값을 매번 2씩 증가시키는 방법
		for(int i = 1; i <= 10; i +=2) {
			System.out.print(i + " "); // 1 3 5 7 9
		}
		//방법2 : 반복문을 돌떄마다 홀수인 경우를 체크해서 출력하는 방법 ( i % 2 == 1) -> 출력
		
		//방법3 : 짝수일 경우 현재 반복을 중지하고 가장 가까운 반복문으로 돌아가는 방법
		System.out.println();
		for(int i = 1; i <= 10; i++) {  // 10회 반복
			if(i % 2 == 0) { // 짝수면
				continue; // 뒷쪽의 내용은 무시하고 다음 증감식 부분으로 넘어감
			}
			System.out.print(i + " ");
		}
	}
	
	public void method2() {
		//1부터 100까지의 총 합계
		//단, 6의 배수값은 빼고 더해보기
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 6 == 0) {
				continue;
			}
			sum+=i;
		}
		//출력 예시 : 총 합계 : xxxx
		System.out.println("총 합계 : " + sum);
	}
	
	
	
	
	
	
	
	
	
	
}
