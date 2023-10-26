package com.kh.chapter04_field;

import com.kh.chapter04_field.model.vo.FieldTest1;
import com.kh.chapter04_field.model.vo.FieldTest2;

public class Run {

	public static void main(String[] args) {
		//-----------------------------------1.fieldTest1-----------------------------
		FieldTest1 ft1 = new FieldTest1();
		// 객체 생성 시점에 global 필드 할당(heap)
		
		//ft1.test(5); // test메서드 호출시 생성되는 변수 : num, l, a (stack)
		//test메서드 호출 종료 시 num. a, l라는 변수는 소멸(stack에서)
		
		ft1 = null; // 객체 소멸시 global 필드도 소멸
		
		//System.out.println(ft1.pro); 같은 패키지가 아니므로 접근 불가. 만약 상속 받았다면 접근 가능
		//System.out.println(ft1.df); 같은 채키지가 아니므로 접근 불가
		
		
		//----------------------------------------------------------------------------
		FieldTest2 ft2 = new FieldTest2();
		
		System.out.println(FieldTest2.sta);
		// sta라는 static변수를 호출하기 위해서는 객체 생성을 할 필요가 없고,
		// 다만 어느 클래스에 있는 sta변수인지 명확하게 클래스명만 기술해주면 됨
		
		FieldTest2.test();
		
	}
	
	

}
