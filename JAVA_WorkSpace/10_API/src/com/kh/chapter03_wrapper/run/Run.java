package com.kh.chapter03_wrapper.run;

public class Run {

	public static void main(String[] args) {
		/*
		 * Wrapper 클래스
		 * => 기본 자료형을 객체로 포장해주는 클래스들을 Wrapper클래스라고 함
		 * 
		 * 		기본 자료형	<->		Wrapper 클래스
		 * 		boolean				Boolean
		 * 		char				Character *
		 * 		byte				Byte
		 * 		short				Short
		 * 		int					Integer *
		 * 		long				Long
		 * 		float				Float
		 * 		double				Double
		 * 
		 *    * :Wrapper 클래스일 때 이름이 다르기 때문에 외우기
		 *     
		 */
		int num1 = 10;
		int num2 = 15;
		
		//System.out.println(num1.equals(num2));  // 불가능
		// 일반적인 기본 자료형에서 객체 자료형의 메서드를 활용하고 싶으면
		// Wrapper클래스로 변환하여 사용한다
		
		Integer i1 = num1; // 자동형변환 ( 기본자료형 -> Wrapper 자료형) => Boxing을 했다고 함.
		Integer i2 = num2;
		
		System.out.println(i1.equals(i2)); // false	15 != 10
		// .equals() : 주소값간의 동등비교 (true/false)
		System.out.println(i1.hashCode() + "::::" + i2.hashCode()); // 10::::15
		System.out.println(i1.compareTo(i2)); // -1
		// a.compareTo(b) : 두 값을 비교해서 a가 b보다 크면 1, 같으면 0, b가 더 크면 -1 반환
		
		// Wrapper 자료형 -> 기본자료형 (UnBoxing)  자동형변환
		int num3 = i1;
		int num4 = i2;
		
		System.out.println("================================================");
		
		// 기본자료형 <-> String 클래스
		String str1 = "10";
		String str2 = "15.3";
		
		// 1. String --> 기본자료형 : 파싱한다
		//		해당 Wrapper클래스.parseXXX(변환시킬문자열);
		// parse는 static 메서드 따라서 static 메모리에 저장
		int i = Integer.parseInt(str1); // "10" -> 10
		double d = Double.parseDouble(str2); // "15.3" -> 15.3
		// 빈 문자열이나 null값이 들어가면 에러발생
		
		System.out.println(i+d); // 25.3
		
		// 2. 기본자료형 --> String
		// 		10			"10"
		//		15.3		"15.3"
		//		String.valueOf(변환할 기본자료형 값) : String 반환
		String strI = String.valueOf(i);
		String strD = String.valueOf(d);
		
		System.out.println(strI + strD); // "10" + "15.3" = "1015.3"
		
	}

	
	
	
	
	
	
	
	
}
