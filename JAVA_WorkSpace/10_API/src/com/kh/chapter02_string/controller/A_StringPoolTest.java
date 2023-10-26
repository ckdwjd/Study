package com.kh.chapter02_string.controller;

public class A_StringPoolTest {

	// String 클래스는 불변클래스(변하지 않는 클래스)
	// 수정하는 순간 기존의 값이 담겨있던 공간에서 수정되지 않는다
	
	// String constant Pool(문자열 상수풀)
	// 문자열 데이터가 담기는 영역으로 heap메모리 영역안에 항상 고정적으로 상수풀
	// 영역이 할당되어 있음(JDK7버전이상)
	
	// 1. 생성자를 통해 문자열 담기
	public void method1() {
		String str1 = new String("hello"); 
		// new 객체생성 무조건 heap메모리 안에 고유한 저장공간이 할당됨
		String str2 = new String("hello");
		
		System.out.println("str1 == str2 ? " + (str1 == str2)); // false
		
		System.out.println(str1);
		// String 클래스의 toString() 메서드의 경우 실제 담겨있는 문자열을 반환하도록 오버라이딩 되어있음
		
		System.out.println(str1.equals(str2)); // true => 문자열 비교
		// String 클래스의 equals() 메서드의 경우 주소값 비교가 아닌 문자열 비교를 하도록 오버라이딩 되어있음
		
		System.out.println(str1.hashCode()); // 10진수의 주소값
		System.out.println(str2.hashCode());
		// str1과 str2의 주소값이 동일
		// 기존 hashcode()의 경우 16진수의 메모리 주소값을 10진수형태로 반환해준 값
		// String 클래스의 hashcode()메소드의 경우 주소값 기반이 아닌 실제 담긴 문자열 기반으로 해시코드값을 만들어 반환(오버라이딩 됨)
		// 오버라이딩을 한 이유 ?
		// 문자열은 문자열 기반의 hashcode값을 상수풀상의 주소값으로 저장하고 있음(HashMap으로 구현)
		// 따라서 상수풀 안에 데이터를 저장할 떄 문자열을 해시코드로 변환한 후 그 자리에 데이터가 들어가있는지
		// 검사를 실행하고 이미 들어가있다면 상수풀상의 주소값을 변수에 참조시키고, 없다면 상수풀에 등록시킨 후 그 주소값 반환
		
		// 실제 주소값에 대해 알고싶다면 System.identityHashCode(변수);
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
	
	// 2. 문자열 리터럴로 생성
	public void method2() {
		
		// 프로그램 첫 시작시에 문자열 상수풀에 들어가 있는 데이터가 없다
		// 문자열을 사용할 때마다 추가 됨
		String str = new String("Hello"); // heap메모리에 객체생성됨
		
		String str1 = "hello";/* new String("Hello").intern(); */ // 상수풀에 hello 문자열 저장
		String str2 = "hello";/* new String("Hello").intern(); */ // Hello 문자열이 이미 상수풀에 저장되어 있기 때문에 값을 저장하지 않음
		// 동일한 주소값을 str2에 저장 
		String str3 = "World"; // 상수풀에 world문자열 저장
	
		System.out.println(str1 == str2);
		
		// JVM이 클래스안의 정보를 읽어들이면서 문자열 리터럴 값을 만나면 상수풀에 등록
		// 리터럴 값을 new String("문자열")으로 감싸줌
		// 그 후에 intern()이라는 메서드를 호출함
		// intern() : 상수풀 안에 내가 생성한 문자열이 존재하는지 체크하고 존재한다면 문자열을 반환
		//			  존재하지 않는다면 상수출에 문자열을 등록 후 문자열 반환
		
		// 따라서 동일한 문자열 리터럴 제시시 새롭게 저장공간을 할당하지 않고 이미 저장된 주소값을
		// 공유해서 사용하므로 효율적으로 저장공간을 활용할 수 있음
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
	
	// 불변 클래스
	public void method3() {
		
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		
		str = "goodbye";
		System.out.println(System.identityHashCode(str));
		
		str += "abc";
		System.out.println(System.identityHashCode(str));
		
		/*
		 * 자바에서 가장 많이 사용되는 객체 => String
		 * String이 메모리 영역에서 사라지지 않는다면 메모리부족 이슈가 발생할 것
		 * 기존의 상수풀의 연결이 끊긴 문자열들은 가비지 컬렉터가 정리해줌(java7 이후)
		 * 불변이라고 해서 수정이 불가능한게 아니라, 원래 주소값에서 수정이 안되는 뜻
		 * 매번 새로운 주소값을 참조하게 됨
		 * 
		 * 따라서 문자열 사용할 때 new String을 통해 객체를 생성하는 것보다, 
		 * 리터럴로 문자열을 만드는 것을 더 권장함(주소값을 공유해서 사용)
		 */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}