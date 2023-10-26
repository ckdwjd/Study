package com.kh.variable;

public class D_Print {
	
	public void printfTest() {
		/*
		 * System.out.println(출력하고자 하는 값); -> 값 출력 후 줄바꿈(개행) 자동으로 넣어줌
		 *
		 * System.out.print(출력하고자 하는 값); -> 값을 출력만 해줌
		 * 
		 * System.out.printf("출력하고자 하는 형식", 출력하고자 하는 값); 
		 * => f는 format(형식)을 의미
		 * => 형식에 맞춰서 값들이 출력만 되고 끝(줄바꿈X)
		 * => 문자열 안에 그 값이 들어갈 자리를 다음과 같은 형식으로 잡아줘야 함
		 * 
		 * 형식
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열
		 */
		
		// 정수 테스트
		int iNum1 = 10;
		int iNum2 = 20;
		// iNum : xx, iNum2 : xx <<- 출력
		
		//1. println() 사용
		System.out.println("iNum1 : "+iNum1+", iNum2 : "+iNum2);
		
		//2. printf 사용해서 변경 => 정수값이기 때문에 %d로 공간을 확보한다. + 개행이 없으므로 개행문자를 직접 넣어줌
		System.out.printf("iNum1 : %d, iNum2 : %d \n", iNum1, iNum2);
		
		// 10 + 20 = 30을 출력하기
		//1. println() 사용해서 출력
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2));
		
		//2. printf로 사용
		System.out.printf("%d + %d = %d \n", iNum1, iNum2, iNum1+iNum2);
		
		System.out.printf("%5d\n", iNum1);  //%5d : 5칸의 공간을 확보하고, 오른쪽으로 값을 정렬
		System.out.printf("%-5d\n", iNum1);  // %-5d : 5칸의 공간을 확보하고, 왼쪽에서부터 값을 정렬
		
		// 실수 테스트
		double dNum = 4.27546789;
		System.out.printf("dNum : %f \n", dNum);
		//%f : 소숫점 아래 7번째 위치에서 반올림괴며, 소숫점 아래 6개까지만 출력
		
		System.out.printf("dNum : %.1f \n", dNum);
		System.out.printf("dNum : %.1f%% \n", dNum); //%% :출력값 뒤에 %를 넣어줌
		//.1f : 소숫점 아래 2번째 줄에서 반올림되어 소숫점 첫 번째 자리까지만 출력
		//.자릿수로 소숫점을 제어, .n번째는 n+1 자리에서 반올림
		
		//내가 지정한 포맷의 갯수와 종류(자료형), 뒤에 오는 변수 혹은 값과 그 종류가 정확히 일치해야함
		
		//문자와 문자열 테스트
		char ch = 'a';
		String str = "Hello";
		
		// 영문자 대문자 알파벳이 들어가는 경우 대문자로 변경
		System.out.printf("%c %s \n", ch, str); // a Hello
		System.out.printf("%C %S \n", ch, str); // A HELLO
		
		
		
		
	}
	
	
	
}
