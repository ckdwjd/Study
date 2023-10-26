package com.kh.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_CheckedException {
	/*
	 * CheckedException은 "반드시" 예외처리를 해야하는 예외들
	 * (즉, 예측 불가능한 곳에서 에러가 발생하기 때문에 미리 예외처리구문을 작성해야함)
	 * => 주로 외부매체와 어떤 입출력을 할 때 발생
	 */
	
	public void method1() {
		
			try {
				method2();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void method2() throws IOException {
		
		// Scanner와 같이 키보드로 값을 입력 받을 수 있는 객체(단, 문자열로만 가능)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReaader와 InputStreamReader은 단독으로 사용이 불가눙
		
		System.out.print("아무 글자나 입력해주세요 : ");
		
//		try {
//		String str = br.readLine(); // 이 메소드를 호출하기 위해선 IOException이 발생할 수 있으므로 예외처리를 해야함
//		System.out.println("문자열의 길이 : " + str.length());
//		} catch(IOException e) {
//			System.out.println("예외 발생"); // 예외가 언제 발생할지 모름
//		}
		
		// 2. throws : 지금 현재 메소드에서 발생한 예외를 본인을 호출한 메서드로 떠넘기는 키워드
		String str = br.readLine(); // 예외처리 자동완성 기능 사용
	}
	/*
	 * 									예외 발생 시점									예외 처리
	 * RuntimeException		프로그램 실행 시 => 런타임 에러(컴파일 에러 x)	필수 아님 => UnCheckedException(조건문으로 예외처리 가능)
	 * IOException				그 외		 => 컴파일 에러				  필수   => CheckdedException(반드시 예외처리로 해결)
	 */
	
}
