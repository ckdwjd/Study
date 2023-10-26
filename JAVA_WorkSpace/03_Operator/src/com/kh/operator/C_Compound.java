package com.kh.operator;

public class C_Compound {
	
	/*
	 * 복합대입연산자 : 산술연산자와 대입연산자를 함꼐 사용하는 연산자
	 * 연산처리 속도가 빨라지므로 사용하는걸 권장
	 * +=, -=, *=, /=, %=
	 * 
	 * a = a + 3;   =>   a += 3;
	 * a = a - 3;   =>   a -= 3;
	 * a = a * 3;   =>   a *= 3;
	 * a = a / 3;   =>   a /= 3;
	 * a = a % 3;   =>   a %= 3;
	 * 
	 * 기존 a값에 3을 더하거나, 빼거나, 나누거나, 곱하고 그 결과 값을 다시한번 a변수에 대입
	 */
	
	public void method() {
		
		int num = 12;
		
		System.out.println("현재 num : " + num);
		
		//num을 3만큼 증가
		num = num+3;
		System.out.println("3증가시킨 num : " + num);
		
		//num을 3만큼 증가
		num += 3;
		System.out.println("또 3증가시킨 num : " + num);
		
		//num을 5 감소
		num -= 5;
		System.out.println("5를 감소시킨 num : " + num);
		
		//num을 6배 증가
		num *= 6;
		System.out.println("6배 증가시킨 num : " + num);
		
		//num을 2배 감소
		num /=2;
		System.out.println("2배 감소시킨 num : " + num);
		
		//num을 4로 나누었을 때 나머지 num에 대입
		num %= 4;
		
		System.out.println("현재 num : " + num);
		
		// +=의 경우 문자열도 접합이 가능
		String str = "hello";
		str += "world";
				
		System.out.println(str);
		
		
		
	}
	
	
	
	
	
	
	
}
