package com.kh.chap05_generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GenericRun<G , Generic> { // 글자 숫자 상관없음(1글자로 작성하는게 관례)
	
	G g; // 클래스나 메서드에 제네릭 타입을 사용하게 되면 해딩 클래스나 내부에 들어가는 데이터 타입을 컴파일 하는 시점에서 지정됨
	Generic gen;

	public static void main(String[] args) {
		
		/*
		 * !! 제네릭을 설정하는 이유 !!
		 * 1. 명시한 타입의 객체만 저장가능하도록 타입의 제한을 두기 위해 => 안정성 확보
		 * 2. 컬렉션에 저장된 객체를 꺼내서 사용할 떄 형변환 절차를 없애기 위해 
		 * => JDK1.5버전 이하에선 제네릭을 지원하지 않아 Object객체를 저장하고 꺼낼 때 강제형변환 진행
		 */

		// 제네릭 등장 이전
		List l = new ArrayList(); // 컬렉션 안에 담긴 데이터의 실제 자료형 모름
		Iterator i = l.iterator();
		while(i.hasNext()) {
			System.out.println((String)i.next()); // 꺼냈을 대 어떤 자료형인가 -> 모름
			// 특정 클래스안에 담긴 함수를 호출하기 위해 다운캐스팅 하려고 했을 때, 내부에 들어가있는 데이터 타입이
			// 다운 캐스팅하고자 하는 클래스의 상속관계가 아닐 수 있음 => ClassCastException 발생
			// 따라서 내부적으로 들어갈 데이터 타입을 한정지을 수 있는 방법인 Generic이 등장
		}
		
		/*
		 * 제네릭<Generic>
		 * 
		 * 데이터 타입을 일반화 한다라는 의미. 여러 타입을 하나의 타입으로 일반화 시킴
		 * 
		 * 컬렉션과 함께 가장 많이 사용되며 저장할 객체를 제한하는 기능으로 오직 한가지 종류의 클래스만 저장할 수 있게 해놓은 기능
		 * 
		 * 별도의 제네릭 제시 없이 컬렉션 객체를 생성하게 되면 해당 컬렉션에 다양한 타입의 데이터 값들이 담길 수 있음
		 * 별도의 제네릭 설정을 <Music> 한 후 해당 컬렉션 안에는 오직 Music객체만 담길 수 있음
		 * 
		 * <E> , <T> , <K> , <?> : 타입변수라고 부름. 내부에 들어간 알파벳 단어에는 기능이 없다(개발자간의 암묵적 규칙 존재)
		 * 						   임의의 정해지지 않은 참조 자료형 타입을 의미. 실제 데이터 타입은 컴파일 시점에 정해짐*
		 * 						   컴파일 시점 : 제네릭 클래스 객체생성, 제네릭이 붙은 매개변수, 반환형이 있는 메서드 호출 시
		 * 
		 * 				 정리하자면   제네릭 타입은 그 자리에 대입되어야할 참조자료형 값이 있다라는 의미, 들어갈 실제 타입은
		 * 						   컴파일하는 시점에 내가 작성한대로 추가된다라는 의미
		 */
		
		GenericRun<Integer, String> gr1 = new GenericRun();
		// 컴파일 되는 시점에 G == Integer, gen == String으로 변환
		gr1.g = 10;
		gr1.gen = "문자열";
		
		GenericRun<String, Integer> gr2 = new GenericRun(); 
		// 객체 생성 시점에 G == String, gen == Integer타입으로 변환
		gr2.g = "여기가 문자열";
		gr2.gen = 10;
		// 들어갈 데이터 타입을 미리 정의해두지 않음으로써 확장성을 크게 늘림
		
		// 제네릭의 단점
		
		// ===================================================================
		// 객체배열을 통해 다형성에 대해 알아보기
		Integer[] arr = new Integer[] {1,2,3,4,5};
		
		Object[] oArr = new Object[5];
		oArr = arr; // 다형성의 원리에 의해 UpCasting으로 자동형변환됨
		System.out.println(Arrays.toString(oArr));
		
		ArrayList<Integer> list = new ArrayList();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);

		ArrayList<Object> list2 = new ArrayList();
		
		//list2 = list; // 제네릭 끼리는 상속관계가 적용이 안됨
		// ArrayList<Integer>와 ArrayList<Object>는 완전 다른 별개의 클래스
		// 제네릭은 정말 오직 <g>으로 전달받은 데이터 타입과 일치해야만 서로 받아줄 수 있다
		
		// 문제점 : 제네릭의 최대 장점이 바로 들어갈 데이터타입을 미리 정의해두지 않고 컴파일 시점에 정해줌으로써
		// 확장성을 늘려주는 것인데, 이러면 제네릭을 사용하는 의미가 퇴색되어버림
		
		gr1.printTest(list);
		//gr1.printTest(list2); // 에러발생, 제네릭을 추가 시 오직 같은 타입변수만 추가 가능하므로 확장성이 떨어짐
								// Object나, 그 외 타입의 매개변수를 가진 함수를 계속 추가 생성해야함
		
		// 해결방법 ( <?> 타입(와일드키드))
		// ? (UnknownType) : 정해지지 않은 타입. 제네릭으로 지정할 타입을 지정하지 않았다는 의미 => 어떤 값이든 들어감
		
		ArrayList<?> list3 = new ArrayList(); // 어떤 타입의 제네릭값이든 다 담을 수 있음
											  // 들어오는 데이터 타입을 신경쓰지 않음
		list3 = list; // <Integer> 타입 가능 
		list3 = list2; // <Object> 타입 가능
		// any type != unknown type
		
		Iterator<?> it = list3.iterator();
		while(it.hasNext()) {
//			it.next(); // 꺼낸 요 데이터 값의 자료형은 무엇인가? => 모름(데이터 타입을 정해지지 않기 때문)
					   // 								   단순 꺼내기만 하면 에러 발생 x
			System.out.println(it.next()); 
			// 내부에 어떤 자료형의 데이터가 있는지 모르지만, 최소한 Object클래스의 먼 자손일 것이기 때문에
			// 다형성의 원리에 의해 println의 매개변수로 넣어줄 수 있음
		}
		
		// <?>의 단점
		// ArrayList에 데이터를 추가하는 상황일 때 제네릭 타입으로 ?를 설정했기 때문에 아무 값이나 넣어도 상관없어 보임
		//list3.add(1); // 추가시 컴파일 에러 발생
		
		/*
		 * 제네릭 설정이 ?라면 넣고자 하는 객체가 ? (unknownType)이여야 함
		 * 하지만 타입 자체가 정해지지 않은게 ? 이므로, 들어가는 타입이 제네릭으로 지정한 타입인지 논리적으로 검사자체를 할 수 
		 * 없기 때문에 에러 발생
		 * 
		 * ? 가 가질 수 있는 클래스 범위는 무한대. ? 자리에는 String, Integer, Book, Student, Object등 들어올 수 있음
		 * 따라서, 제대로 값이 들어갔는지 검사 자체가 불가능하기 때문에 컴파일 단계에서 에러 발생한 것
		 * 
		 * list3.add("문지열"); // 만약에 ? Integer클래스였다면 에러 발생
		 * list3.add(1); // 만약에 ? String클래스였다면 에러 발생
		 * list3.add(new Object()); // 만약에 ?가 Objectr가 아닌경우 무조건 에러 발생
		 * 
		 * 즉, ?는 어떤 타입(any)이든 넣을 수 있는 타입변수가 아니라 자료형이 정해지지 않은 타입변수
		 * 단, get을 사용해서 컬렉션 안에 들어가있는 값을 꺼낼 때는 자료형에 대한 검사가 별도로 필요 없으므로 에러 발생X
		 * 
		 * 문제점은 결구 ?가 가질 수 있는 자료형의 범위가 "무한대"이기 떄문에 발생
		 * 해결방안으로 ?의 자료형의 범위를 상속구조를 통해 한정 짓는 방법을 찾게됨
		 * 
		 * 1. 상한 경계 설정
		 * - 와일드카드(?)가 가질 수 있는 자료형의 "최댓값"을 설정하는 방법 == 상위클래스를 제한
		 * 	[표현법]
		 * 	클래스명<? extends T> : ?가 가질 수 있는 최고 높은 자료형은 T(T와 T의 자손들만 제네릭으로 들어올 수 있음)
		 * 	(값을 꺼내쓸 때 사용하는 걸 권장!)
		 * 
		 * 2. 하한 경계 설정
		 * - 와일드카드(?)가 가질 수 있는 자료형의 "최솟값"을 설정하는 방법 == 하위클래스 제한
		 * 	[표현법]
		 * 	클래스명<? super T> : T와 T의 조상클래스만 가능(?가 가질 수 있는 가장 낮은 자료형은 T)
		 * 	(값을 추가할 때 사용하는 걸 권장!)
		 */

		List<? extends Parent> upperBoundary = new ArrayList();
		
		for(Parent p : upperBoundary) { 
			// List에 들어가있는 값은 모름. 하지만 최소한 Parent클래스는 상속 받았으므로
			// 다형성 원리에 의해 자동형변환이 가능해지기 때문에 에러발생하지 않음
			System.out.println(p);
		}
//		for(Child1 p : upperBoundary) {
//		// 에러 발생. Child1이 자식클래스 이지만 Parent의 자식이 다양하게 존재할 수 있으므로
//		// ?가 Child2라면 컴파일 에러가 발생
//			System.out.println(p);
//		}
		
//		upperBoundary.add(new Parent()); // 에러 발생
//		// ?는 Parent 또는 Child1, Child2일 수 있기에 자동형변환이 안되서 넣을 수 없다
//		upperBoundary.addAll(new Child1()); // ?가 Parent라면 가능 Child2인 경우 에러 발생
//		upperBoundary.add(new Object()); // Object는 최상위 클래스이기 때문
		
		List<? super Parent> lowerBoundary = new ArrayList();
//		for(Parent p : lowerBoundary) { // 컴파일 에러. Parent보다 더 큰 부모타입이 ?에 대입될 수 있기 때문에
//			
//		}
		for(Object o : lowerBoundary) { // ?에 들어가있는 타입이 Object이거나 자손이므로 자동형변환
			
			
		}
		// 값을 출력시에는 불편함. 하한 경계 설정은 값을 넣을 때 사용하는걸 권장
		
		lowerBoundary.add(new Child1()); // 경계선 상에 더 밑에 존재하기 때문에 UpCasting발생
		lowerBoundary.add(new Parent()); // 가능
		
//		lowerBoundary.add(new Object()) // 경계선상 더 위에 존재하므로 불가능
		
		
	}
	
	public G test(G g) { // 메서드의 반환형, 매개변수에도 제네릭 타입 지정 가능
		return g;
	}
	
	public void printTest(ArrayList<Integer> list) {
		for( Integer i : list) {
			System.out.println(i);
		}
	}
	
	public void printTest1(ArrayList<Object> list) {
		for( Object o : list) {
			System.out.println(o);
		}
	}
}

class Parent{
	
}

class Child1 extends Parent{
	
}

class Child2 extends Parent{
	
}