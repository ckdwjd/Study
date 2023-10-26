package com.kh.chapter02_abstractAndInterface.part01_basic.run;

import com.kh.chapter02_abstractAndInterface.part01_basic.model.vo.Basketball;
import com.kh.chapter02_abstractAndInterface.part01_basic.model.vo.Football;
import com.kh.chapter02_abstractAndInterface.part01_basic.model.vo.Sports;

public class Run {

	public static void main(String[] args) {

		//Sports s2 = new Sports();
		// 추상클래스로는 객체생성이 불가능함
		// 미완성된 클래스이기 때문
		
		Sports s = new Football(); // 객체생성은 안되지만, 참조변수로 사용가능
		
		Sports[] arr = new Sports[2]; // 다형성은 적용가능
		arr[0] = new Basketball();
		arr[1] = new Football();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].rule();
		}
		
		/*
		 * 추상클래스
		 * - 미완성된 클래스 abstract class
		 * - 객체생성 불가(딘, 참조변수로 선언 가능)
		 * - 추상메서드가 존재하는 순간 반드시 추상클래스로 정의해야함
		 * 	(일반필드 + 일반메서드 + [추상메서드(생략가능)]
		 * 
		 * 	단, 추상메서드가 없어도 추상클래스로 만들 수는 있다
		 * 	언제? 클래스가 아직 구체적이지 않은 덜 구현된 상태일 때(개념적)
		 * 		 현재 이 클래스를 객체생성이 불가하게끔 하고자 할 때(기술적)(거의 안쓰임)
		 * 
		 * 추상메서드
		 * - 미완성된 메서드로 몸통부 {}가 구현되어있지 않은 메서드
		 * - 자식클래스에서 오버라이딩을 통해 완성됨(강제 오버라이딩해야함)
		 * 		=> 오버라이딩 하지않을 경우 에러발생
		 * 		=> 메서드 사용의 통일성을 확보할 수 있음
		 * 		=> 표준화된 틀을 제공할 수 있다
		 * 
		 * 
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
