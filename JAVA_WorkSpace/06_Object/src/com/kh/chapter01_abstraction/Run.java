package com.kh.chapter01_abstraction;

import com.kh.chapter01_abstraction.model.vo.Student;

public class Run {

	/* 
	 * 1. 객체지향언어 : "객체"를 지향하는 언어로 "객체중심"으로 돌아간다
	 * 
	 * 2. 객체란? 사전적 의미로 현실세계에 존재하는 모든 것을 의미(유형, 무형, 개념, 사물)
	 * 
	 * 3. 객체지향 프로그래밍 : 현실세계에서 독립적인 존재들인 객체들간의 상호작용을 프로그래밍을 통해 가상세계로 구현하는 과정
	 * 
	 * 4. 구현하고자 하는 프로그램상의 필요한 객체를 만들기 위해서는 클래스라는 틀을 만들어야함
	 * 		(클래스 : 각 객체들의 속성(정보)들을 담아낼 수 있는 그릇같은 존재) -> 1단계 추상화 + 2단계 캡슐화
	 * 
	 * 5. 추상화 과정
	 *  1) 내가 구현하고자 하는 프로그램에서 필요한 객체를 생각할 것 ex)학생관리 프로그램 => '학생' : 홍길동학생, ...
	 *  2) 그 객체들이 가지고 있는 공통적인 속성, 기능들을 모두 호출할 것 ex) 이름, 나이, 성별, 학년, 학번, 주소, 주민번호, 전화번호 ...
	 *  3) 추출한 데이터를 가지고 구현할 프로그램의 "실질적인 목적"에 맞춰 불필요한 속성, 기능들을 제거해서 추려나가기
	 *  4) 최종적으로 추려진 속성들을 가지고 어떤 자료형에 어떤 이름으로 사용할지 생각하기
	 *  
	 * 예) 학생관련 프로그램 
	 *   1) 학생 관련 객체(홍길동 학생, 이순신 학생...)
	 *   2) 공통적인 속성 및 기능(이름, 나이, 학년, 성별, 학번, 과목점수, 체지방률, ... )
	 *   3) 학생 "인적사항"을 관리하는 프로그램이다? -> 이름, 나이, 성별, 학년, 학번, 주소, 전화번호, 주민번호, ...)
	 *   	학생 "성적"을 관리하는 프로그램이다? -> 이름, 학번, 학년, 국어점수, 수학점수, 영어점수
	 *   	학생 "건강"을 관리하는 프로그램? -> 이름, 학번, 학년, 키, 몸무게, 체지방률, ...
	 *   	=> 추려내는 것이 핵심적인 과정
	 *   4) 최종적으로 추려진 데이터들을 가지고 사용할 자료형과 변수명 설정 : 이름, 학번, 키
	 *   	이름 => String name;  
	 *   	학번 => int stdNo;
	 *   	키 => double height;
	 *   
	 * 6. 선정한 것들을 가지고 본격적인 프로그래밍 시작
	 * 		1) "변수"만으로 프로그래밍을 한다면?
	 * 			변수 : 하나의 자료형으로 하나의 값만 보관할 수 있음
	 * 			홍길동이라는 객체를 만들기 위해서? String name1 = "홍길동"; int stdNo1 = 20200315; double height1 = 180.5;
	 * 			민경민이라는 객체를 만들기 위해서? String name2 = "민경민"; int stdNo2 = 20230315; double height2 = 133.5;
	 * 
	 * 			=> 수백명의 학생을 관리하는 프로그램을 구현해야 할 경우, 변수가 수천개가 생길 수 있음(관리하기 까다롭다)
	 * 
	 * 		2) "배열"을 이용해서 프로그래밍을 하게 된다면?
	 * 		    배열 : 동일한 자료형의 여러개의 값을 한번에 보관할 수 있음
	 * 		    학생의 이름을 보관하는 배열 => String[] name = {"홍길동", "민경민", "오창정", ...};
	 * 		    학번을 보관하는 배열 		 => int[] stdNo = {2020, 202031, 2031203102, ...};
	 * 		    학생의 키를 보관하는 배열  => double height = {180.5, 177.2, 180.0, ...};
	 * 
	 * 		3) 구조체라는 개념
	 * 			구조체 : 한번에 여러개의 자료형을 보관할 수 있는 배열 같은 형태
	 * 					String값도 보관, int값도 보관, double , char, 그 외 참조자료형 ...
	 * 					나만의 배열같은 자료형을 만들 수 있음 = 클래스(Class)
	 * 			클래스 : 각 객체들의 속성정보(name, stdNo, height)를 담아낼 수 있는 그릇(틀)과 같은 존재
	 *  				클래스를 보관할 때 보관할 패키지명은 vo(value Object)
	 *  
	 */
	public static void main(String[] args) {
		
		// 1. 변수만 가지고 프로그래밍 하기
//		String name1 = "민경민";
//		int age1 = 50;
//		double height1 = 180.9;
		
		// 2. Student -> 학생 객체를 뽑아내기위한 틀(클래스)
		// 홍길동 학생 객체 만들기
		Student hong = new Student();  // 객체 생성(메모리 영역(heap영역)에 공간 할당)
		// 각각의 필드에 직접적으로 접근해서 값 대입
		hong.name = "홍길동";
		hong.stdNo = 20230331;
		hong.height = 199.4;  // 필드, 메서드 접근시 . 으로 가져온다
		
		// 오창정 학생 객체 만들기
		Student oh = new Student();
		oh.name = "오창정";
		oh.stdNo = 201719037;
		oh.height = 181.1;
		
		System.out.println(hong);  // 1eb44e46
		System.out.println(oh);  // full클래스명@1c4af82c
		
		//xx님의 학번은 xxxxx이고, 키는 xxxcm 입니다.
		
		System.out.printf("%s님의 학번은 %d이고, 키는 %.1fcm 입니다.\n",hong.name ,hong.stdNo, hong.height);
		System.out.printf("%s님의 학번은 %d이고, 키는 %.1fcm 입니다.",oh.name ,oh.stdNo, oh.height);
		
		/*
		 * 필드를 public으로 작성시
		 * => 직접적으로 접근해서 값 대입 가능, 조회할 수 있는 경우 보안 문제가 발생할 수 있음
		 * => 외부에서 함부로 값을 변질시키거나, 조회권한이 없는 사람이 값을 쉽게 가져올 수 있는 문제 발생
		 * => 값을 함부로 바꾸면 안되는데 변경될 수 있음
		 * 
		 * =>> 문제 해결을 위한 방법으론 = 캡슐화
		 * 객체지향 설계 원칙 중 하나 (정보 은닉)
		 */
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
