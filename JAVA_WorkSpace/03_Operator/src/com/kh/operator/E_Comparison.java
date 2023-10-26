package com.kh.operator;

public class E_Comparison {
	/*
	 * 비교연산자 / 관계연산자(이항연산자)
	 * 두 개의 값을 가지고 비교
	 * 비교 연산한 결과가 참일 경우 true / 거짓일 경우 false 값을 반환(즉, 반환값이 boolean)
	 * => 후에 특정 조건을 제시할 수 있는 조건문에서 많이 쓰일 예정
	 * 
	 * 크고 작음을 비
	 * a < b : a가 b보다 작습니까?
	 * a > b : a가 b보다 큽니까?
	 * a <= b : a가 b보다 작거나 같습니까?
	 * a >= b : a가 b보다 크거나 같습니까?
	 * 
	 * 일치함을 비교(동등비교)
	 * a == b : a가 b가 같습니까?
	 * a != b : a와 b가 같지 않습니까?
	 */
	
	public void method1() {
		
		int a = 10;
		int b = 25;
		//int a = 10, b = 25; : ,를 이용하여 변수 선언 가능하나 권장하지 않음
		
		System.out.println("a > b : " + (a > b));
		// 비교연산보다 산술연산이 우선순위가 더 크기 떄문에 a>b는 괄호로 묶어서 우선순위를 높여줘야 함
		System.out.println("a <= b : " + (a <= b));
		
		boolean result1 = (a == b); // false
		
		boolean result2 = (a != b); // true
		
		//산술연산 + 비교연산
		System.out.println((a - b) < 0); //true
		
		System.out.println((a / 2) > (b / 5)); //false
		
		System.out.println("a가 짝수입니까 : " + (a % 2 == 0));  //true
		System.out.println("a가 짝수입니까 : " + (a % 2 != 1));  //true
		System.out.println("a가 홀수입니까 : " + !(a % 2 == 1));  //true
		
		// 어떤 값을 2로 나누었을 때, 나머지값이 0이나, 1이냐를 가지고 홀수인지 짝수인지 판별가능.

	}
	public void quiz() {
		
		int a = 5;
		int b = 10;
		
		int c = (++a) + b; // 6 + 10 =  16
		int d = c / a; // 16 / 6 = 2
		int e = c % a; // 16 % 6 = 4
		
		int f = e++; //4(5) 
		int g = (--b) + (d--); //9 + 2(1) = 11(10) 
		int h = 2; // 2
		
		int i = (a++) + b / (--c / f ) * (g-- - d) % (++e + h);
		//		 6(7) + 9 / (15 / 5) * (10 - 1) % (6 + 2)
		//		   6  +  9  /  3  *  10  %  8 
		
		// a : 7, b : 9, c : 15, d : 1, e : 6, f : 4, g : 10, h : 2, i : 12 계산 후 변수의 값
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		
	}
	
	
	
	
	
	
	
	
}
