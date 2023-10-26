package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice {
	
	public void CastingPrac1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		double korean = sc.nextDouble();
		
		sc.nextLine();
		System.out.print("영어 : ");
		double english = sc.nextDouble();
		
		sc.nextLine();
		System.out.print("수학 : ");
		double math = sc.nextDouble();
		
		sc.nextLine();
		System.out.println("총점 : " + (int) (korean + english + math));
		System.out.println("평균 : " + (int) (korean+english+math)/3);
	}
	
	public void CastingPrac2() {
		
		int iNum1 = 10; 
		int iNum2 = 4;
		
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		
		char ch = 'A';
		
		
		System.out.println(iNum1 % iNum2 ); // 2 
		System.out.println((int)(dNum)); // 2
		
		System.out.println(iNum2 * dNum ); // 10.0 
		System.out.println((double)iNum1 ); // 10.0
		
		System.out.println((double)(iNum1) / (iNum2) ); // 2.5 
		System.out.println(dNum ); // 2.5
		
		System.out.println( (int)(fNum)); // 3 
		System.out.println(iNum1/(int)(fNum) ); // 3
		
		System.out.println((iNum1) / fNum);// 3.3333333 
		System.out.println( (double)(iNum1) / fNum); // 3.3333333333333335
		
		System.out.println( ch ); // 'A' 
		System.out.println( (int)ch ); // 65
		
		System.out.println( (int)ch + iNum1 ); // 75 
		System.out.println( (char)(ch + iNum1) ); // 'K'
		
	}
	
}
