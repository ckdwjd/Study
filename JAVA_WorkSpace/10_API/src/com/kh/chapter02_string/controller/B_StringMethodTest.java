
package com.kh.chapter02_string.controller;

import java.util.Arrays;

public class B_StringMethodTest {

	// 문자열과 관련된 유용한 메서드
	public void method() {
		
		String str1 = "Hello World";
		
		// 1. 문자열.charAt(int index) : char(반환형)
		// 	  문자열에서 전달받은 index위치의 문자 하나만 뽑아서 리턴
		char ch = str1.charAt(4); 
		System.out.println("ch : " + ch); // 'o'
		
		// 2. 문자열.concat(String str) : String(반환형)
		//	  문자열과 전달된 또다른 문자열을 하나로 합쳐서 리턴
		String str2 = str1.concat("!!"); // Hello World!!
		System.out.println("str2 : " + str2);
		// str1 + "!!";

		// 3. 문자열.substring(int beginIndex) : String(반환형)
		//	=> 문자열의 beginIndex위치에서 부터 끝까지의 문자열을 추출해서 리턴
		//	  문자열.substring(int beginIndex, int endIndex) : String(반환형)
		//	=> 문자열의 beginIndex에서부터 endIndex - 1 까지의 문자열을 추출해서 리턴
		System.out.println(str1.substring(0, 5)); // Hello
		System.out.println(str1.substring(6)); // World
		System.out.println(str1.substring(6,str1.length())); // World
		System.out.println(str1.substring(0)); // Hello World
		
		// 4. 문자열.replace(char old, char new) : String(반환형)
		//	=> 문자열에서 old문자를 new 문자로 변환 후 리턴
		String str3 = str1.replace('l', 'c');
		System.out.println("str3 : " + str3); // Hecco Worcd
		
		// 5. 문자열.trim() : String(반환형)
		// => 문자열에서 앞, 뒤 공백을 제거한 문자열 리턴
		String str4 = "    J A V A     ";
		System.out.println("trim() : " + str4.trim()); // J A V A (앞, 뒤 공백만 제거)
		
		// 6. 문자열.toUpperCase() : String(반환형)
		//	=> 문자열을 모두 대문자로 변경 후 문자열 리턴
		//	  문자열.toLowerCAse() : String(반환형)
		//	=> 문자열을 모두 소문자로 변경 후 문자열 리턴
		System.out.println("upper : " + str1.toUpperCase()); // HELLO WORLD
		System.out.println("lower : " + str1.toLowerCase()); // hello world
		
		// 7. 문자열.toCharArray() : char[](반환형)
		//	=> 문자열의 각 문자들을 char[]배열에 옮겨담은 후 해당 배열을 리턴
		char[] arr = str1.toCharArray();
		System.out.println(Arrays.toString(arr)); // [H, e, l, l, o,  , W, o, r, l, d]
		
		// 8. static valueof(char[] data) : String(반환형)
		//	=> 전달괸 char[]에 담긴 문자들을 하나의 문자열로 리턴
		System.out.println(String.valueOf(arr)); // Hello World
			
		int num = 1;
//		String a = num + "";  
		String a = String.valueOf(num); // 문자열 "1"
	}
	
}
