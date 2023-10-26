package com.kh.chapter02_encapsulation;

import com.kh.chapter02_encapsulation.model.vo.Student;

public class Run {
	/*
	 * 7. 캡슐화 과정을 통해 완벽한 클래스의 형태를 갖추게 하기
	 * 캡슐화란? 추상화를 통해 정의된 속성들과 기능들을 하나로 묶어 관리하는 기법 중 하나로
	 * 클래스에서의 가장 중요한 목적인 "데이터 접근제한"을 원칙으로 외부로부터 "데이터의 접근을 막고"
	 * 대신에 '데이터를 간접적으로 처리(값을 대입, 값을 돌려줌)'할 메소드를 클래스 내부에 작성해서 관리하는 방식
	 * 
	 * 캡슐화를 하지 않으면 : 외부로부터 직접 접근이 가능하기 떄문에 함부로 값이 변질되거나 조회를 막지 못하는 문제 발생
	 * 
	 *  1) 정보은닉 : private
	 *  	필드들을 외부로부터 직접 접근을 막기 위해 public 대신에 private 접근제한자 사용
	 *  	ex) 학생들이 본인의 성적을 함부로 바꿀 수 없게
	 *  
	 *  ===========================================================================
	 *  
	 * 	2) setter / getter 메서드
	 * 		간접적으로나마 접근해서 값을 담거나(변경하거나) 그 값을 가져올 수 있도록 도와줌
	 *   
	 *  
	 *  
	 *  
	 *  
	 */
	public static void main(String[] args) {
		
		Student hong = new Student();
		Student oh = new Student();
		
		//hong.name;
		//hong.stdNo; The field Student is not visible
		
		/*
		 * 위와 같이 대입할 경우 직접접근이 불가능해짐
		 * 직접 접근을 막았다면 간접적으로나마 접근할 수 있는 메소드를 활용해야한다
		 */
		
		//간접적으로 객체에 저장된 값을 수정할 수 있게 도와주는 메서드 setter 호출
		hong.setName("홍길동");  // hong의 주소값이 setter 메서드에 있는 this로 전달
		hong.setHeight(180.5);
		hong.setStdNo(202303);
		
		oh.setName("오창정");
		oh.setHeight(181.1);
		oh.setStdNo(202304);
		
		//값을 불러올 경우 getter함수 이용
		//System.out.println(oh.name); 출력이 불가능
		
		System.out.println(hong.getName());
		System.out.println(hong.getHeight());
		System.out.println(hong.getStdNo());
		
		System.out.println(hong.toString());
		System.out.println(oh.toString());
		
		System.out.println(hong);  // 자동으로 toString함수를 사용
		System.out.println(oh);    // 자동으로 toString함수를 사용
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
