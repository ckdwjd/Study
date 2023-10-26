package com.kh.chap01_list.part01_arrayList.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.kh.chap01_list.part01_arrayList.model.compare.MusicTitleAscending;
import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ListRun {
	/*
	 * 컬렉션(Collection)
	 * 자료구조가 내장되어있는 클래스로 자바에서 제공하는 "자료구조"를 담당하는 "프레임워크"이다
	 * 
	 * 자료구조
	 * 방대한 데이터를 효율적으로 다를 때 필요한 개념
	 * 
	 * 프레임워크
	 * 효율적인 기능들이 이미 정의되어있는 틀
	 * 
	 * 데이터들이 새로 추가, 삭제, 수정이 되는 기능들(알고리즘)이 이미 정의되어있는 틀이 있다 == 컬렉션
	 * => 다량의 데이터들을 관리하고자 할 때 배열 가지고 충분히 사용 가능했음. 단, 배열의 단점을 보완한 것 == 컬렉션
	 * 
	 * 배열과 컬렉션의 차이점
	 * - 배열의 단점
	 * 1. 배열을 쓰고자 할 때는 먼저 크기를 지정해야 함
	 * 		=> 한번 지정한 크기는 변경 불가
	 * 		=> 새로운 값을 추가하고자 할때 크기가 오버될 경우 새로운 크기의 배열을 만들고 기존의 내용들을 복사해주는 코드로 직접 서야함
	 * 2. 배열 중간 위치에 새로운 데이터를 추가하거나 삭제하는 경우 기존의 값들을 떙겨주는 코드도 직접 써야함
	 * 3. 한 타입의 데이터들만 저장 가능
	 * 
	 * - 컬렉션의 장점
	 * 1. 크기에 제약이 없다
	 * 		=> 크기지정을 해줄 필요도 없고 만일 크기지정을 해도 알아서 크기가 늘어나고 새로운 데이터를 추가해주는 코드가 이미 정의되어있음
	 * 2. 중간에 값을 추가 및 삭제하는 경우 값을 땡겨주는 코드가 이미 메소드로 정의되어 있음
	 * 3. 기본적으로 여러 타입의 데이터들을 저장할 수 있음
	 * 		(단, 제네릭 설정을 통해서 한 타입의 데이터들만 들어올 수 있게 설정 가능)
	 *
	 * 방대한 데이터들을 단지 담아만 두고 조회할 목정 => 배열
	 * 방대한 데이터들을 빈번하게 추가, 삭제, 수정할 목정 => 컬렉션
	 * 
	 * 컬렉션의 3가지 분류
	 * List 계열 : 담고자하는 값(value)만 저장/ 값 저장 시 순서 유지가 됨(index 개념이 있음) / 중복값 허용
	 * 				예) ArrayList, Vector, LinkedList => ArrayList가 제일 많이 쓰임
	 * 
	 * Set 계열 : 담고자 하는 값(value)만 저장 / 값 저장할 떄 순서 유지가 안됨(index가 없음) / 중복값 허용X
	 * 				예) HashSet, TreeSet
	 * 
	 * Map 계열 : 키(Key) + 담고자 하는 값(value) 세트로 저장 / 값 저장 시 순서유지 X / key값은 중복 허용X
	 * 
	 */
	public static void main(String[] args) {
	
		//ArrayList list = new ArrayList();
		
		// 제네릭 설정하는 이유
		// 1. 명시한 타입의 객체만 저장가능하도록 타입을 제한하기 위해서 => 안정성 확보
		// 2. 컬렉션에 저장된 객체를 꺼내서 사용할 때 매번 형변환 하는 절차를 없애기 위해
		//ArrayList<Music> list = new ArrayList<Music>(3); // <> : 제네릭
		ArrayList<Music> list = new ArrayList<>(3); // 객체 생성 시 제네릭 생략가능(JDK 7이상 가능)
		
		System.out.println(list); // []
//		System.out.println(list.toString()); // [] 즉, 오버라이딩 되어있음
		
		// <E> --> Element 딱히 의미는 없지만 의미부여를 하는 것
		
		
		// 1. add(Music e) : 해당 리스트의 끝에 전달된 e를 추가시켜주는 메서드
		list.add(new Music("bad","크리스토퍼"));
		list.add(new Music("MY BAG","()-IDLE"));
		list.add(new Music("HypeBoy","뉴진스"));
//		list.add(""); // Music 객체로 받기로 했는데 다른 타입의 객체로 설정하면 에러 발생
					  // 단 제네릭 설정을 하지 않으면 여러 타입의 객체 생성 가능
		// 순서가 유지되면서 값이 추가됨(각 index에 값이 담겨있음)
		// 크기에 제약이 없음. 다양한 타입의 값 추가 가능(권장하지 않음)
		
		list.add(new Music("Ditto","뉴진스"));
		// 배열 크기가 3인데 값이 추가되어 있음
		// 애초에 배열 크기를 설정하지 않음
		System.out.println(list);
		
		
		// 2. add(int index, E e ) : list에 전달되는 index값 위치에 전달되는 e를 추가하는 메서드
		list.add(1, new Music("바다의 왕자","박명수"));
		
		System.out.println(list);
		
		
		// 3. set(int index , E e) : 리스트에 해당 인덱스 값을 전달되는 e로 변경시켜주는 메서드
		list.set(0, new Music("heart","뉴진스"));
		
		System.out.println(list);
		
		
		// 4. remove(int index) : 리스트에 해당 인덱스 값을 삭제시켜주는 메서드
		list.remove(1);
		
		System.out.println(list);
		
		
		// 5. size() : 리스트에 담겨있는 데이터의 수를 반환해주는 메서드 == 배열의 length
		System.out.println("리스트에 담긴 데이터 수 : " + list.size());
		System.out.println("리스트의 마지막 인덱스 : " + (list.size() - 1));
		
		
		// 6.get(int index) : E => 리스트에 해당 index위치에 데이터를 반환해주는 메서드
		// 제네릭 설정 전(강제 형변환 필요)
//		Music m = (Music)list.get(0);
		// 제네릭 설정 후(강제 형변환 불필요)
		Music m = list.get(0);
		System.out.println(m);
		System.out.println(m.getTitle());
		System.out.println(list.get(1).getArtist());
		
		System.out.println("=============================================================================");
		
		ArrayList<Integer> iList = new ArrayList();
		iList.add(1);
		iList.add(2);
		iList.add(100);
		
		// 7. contains(E e) : boolean : 배열 컬렉션 안에 매개인자요소를 포함하고있는지 검사
		System.out.println(iList.contains(3)); // true
		System.out.println(iList.contains(2)); // false
		
		
		// 8. indexOf(E e) : int : 컬렉션 안에 매개인자 요소가 몇번째 인덱스에 있는지
		System.out.println(iList.indexOf(2)); // 1
		System.out.println(iList.indexOf(100)); // 
		
		System.out.println("=============================================================================");

		// 컬렉션을 반복시키는 방법
		
		// 1. 기본 반복문
		
		// 2. for Each문 : 향상된 반복문
		for( Music mu  : list  ) { // 제네릭 타입을 정하지 않으면 Object타입으로 설정
			System.out.println(mu);
		}
		
		System.out.println("=============================================================================");
		
		// 3. Iterator 반복자 : 컬렉션의 내부 인자들을 Iterator안에 담아서 관리(String의 StringTokenizer와 흡사)
		Iterator<Music> iter = list.listIterator();
		while(iter.hasNext()) { // hasMoreTokens
			Music m2 = iter.next(); // nextTokens
			System.out.println(m2);
		}
		
		System.out.println("=============================================================================");
		
		// 9. subList(int index1, int index2) : 해당 리스트로부터 index1에서 index2까지 데이터들을 추출해서 list로 반환 메서드
		List<Music> sub = list.subList(0, 2); // index2(2) 앞까지 추출
		System.out.println(sub);
		
		System.out.println("=============================================================================");
		
		// 10. addAll(Collection c ) : 해당 리스트에 다른 컬렉션에 있는 데이터들을 모두 추가시켜주는 메서드
		list.addAll(sub);
		System.out.println(list);
		
		// 11. isEmpty() : boolean : 해당 리스트가 비어있는지 묻는 메서드(비어있다면 true / 아니면 false 반환)
		System.out.println("리스트가 비어있나 ? : " + list.isEmpty());
		
		// 12. clear() : 리스트 전체를 비워주는 메서드
//		list.clear();
		System.out.println("리스트가 비어있나 ? : " + list.isEmpty());
		
		System.out.println("=============================================================================");

		// 13. sort(List ist) : 컬렉션을 정렬
		ArrayList<String> sList = new ArrayList();
		sList.add("다창정");
		sList.add("나창정");
		sList.add("라창정");
		sList.add("가창정");
		
		Collections.sort(sList); // 기본정렬(가나다라, 1234)에 따라 정렬(오름차순)
		System.out.println(sList);
		
		System.out.println("=============================================================================");

		// 역순으로 정렬
		Comparator<String> comp = Collections.reverseOrder();
		Collections.sort(sList, comp);
		System.out.println(sList);
		
		/*
		 * 직접 정의한 객체들을 정렬하기 위해서 정렬기준을 직접 선언해야함
		 * 객체정렬 방법은 2종류
		 * 
		 * 1. Comparable 인터페이스 구현
		 * 		기본 정렬(한가지) 클래스 내부에 직접 구현
		 * 		compareTo메서드 오버라이딩 --> 정렬기준은 딱 하나만 세울 수 있음
		 * 		가수 이름, 노래 제목
		 * 		가수이름 오름차순, 가수이름 내림차순, 노래제목 오름차순, 노래제목 내림차순
		 * 
		 * 2. Comparator 인터페이스 구현
		 * 		기본정렬 외에 추가적으로 정렬기준을 제시해야할 때
		 * 		별도의 Comparator 구현 클래스를 작성하면 됨(정렬 기준에 대한 갯수 제한이 없음)
		 *		compare메서드를 오버라이딩
		 * 		
		 * 
		 */
		// 기본정렬 : 가수이름 오름차순
		Collections.sort(list);
//		list.sort(null);
		
		System.out.println(list);
		
		// 추가적인 정렬기준 생성
		// 1. 제목기준 오름차순
		Collections.sort(list, new MusicTitleAscending());
		System.out.println(list);
		
		// 2. 제목기준 내림차순
		Collections.sort(list, new MusicTitleAscending().reversed());
		System.out.println(list);
		
		System.out.println("=============================================================================");

		ArrayList<Integer> list2 = new ArrayList();
		list2.add(1);
		list2.add(1);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		
		// 반복문을 통해 컬렉션에 담긴 요소가 1이라면 삭제하기
		
		// 1. 향상된 반복문을 활용하여 삭제(불가능)
//		for(Integer i : list2) { // ConcurrentModificationException : 반복문에서 중간에 요소를 삭제하면 발생
//			if(i == 1) {		 // 삭제 시 index가 변경이되면서 반복이 제대로 진행되지 않기 때문에 발생하는 에러
//				list2.remove(i);
//			}
//		}
		
		// 2. 기본 반복문
//		for(int i = 0; i < list2.size(); i++) {
//			if(list2.get(i) == 1) {
//				list2.remove(i); // 삭제가 되는 순간 size의 사이즈가 1 작아짐
//				i--; // 해결가능하긴 하나 생각하기 어렵고, 경우에 따라 놓치는 경우가 있음
//			}
//		}
		
		// 3. Iterator 사용하기 * 가장 좋은 방법
		Iterator<Integer> iter2 = list2.iterator();
		while(iter2.hasNext()) {
			int s = iter2.next();
			if(s == 3) {
				iter2.remove(); // 현재 가리키고 있는 요소를 제거해주는 함수
			}
		}
		System.out.println(list2);
		
		
		// 14. shuffle : 컬렉션의 내부요소를 랜덤하게 섞어줌
		Collections.shuffle(list);
		System.out.println(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
