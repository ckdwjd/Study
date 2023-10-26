package com.kh.chap02_set.part01_hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import com.kh.chap02_set.part01_hashSet.model.vo.Student;
/*
 * Collection
 * - list : ArrayList  
 * - set : HashSet
 * 
 * set의 특징 : 중복을 허용하지 않는다*
 * 			  저장된 순서를 보장하지 않음
 * 
 * LinkedHashSet : 중복을 허용하지 않는다.
 * 				   저장된 순서를 유지해준다. 
 * 
 * TreeSet : 중복을 허용하지 않는다.
 * 			 오름차순을 자동으로 지원한다.
 * 
 */
public class SetRun {
	
	public static void main(String[] args) {
		
		HashSet<String> hs1 = new HashSet();
		
		// 값 추가 : add(추가할 값)
		
		hs1.add(new String("반갑습니다"));
		hs1.add(new String("안녕하세요"));
		hs1.add(new String("여러분"));
		hs1.add("안녕하세요");
		hs1.add("반갑습니다");
		
		System.out.println(hs1); // [반갑습니다, 안녕하세요, 여러분]
		// 중복값 X(생성자를 통해 작성해도 제거) , 순서 유지 X
		
		// 크기 구하기 : size()
		System.out.println(hs1.size());
		
		// 값 삭제 : remove(삭제할 값)
		hs1.remove("여러분");
		
		System.out.println(hs1); // [반갑습니다, 안녕하세요]
		
		// 모든 값 삭제 : clear()
		hs1.clear();
		
		System.out.println(hs1); // []
		
		
		System.out.println("========================================");
		
		HashSet<Student> hs2 = new HashSet();
		hs2.add(new Student("공유",40,100));
		hs2.add(new Student("홍길동",30,90));
		hs2.add(new Student("김값생",20,80));
		hs2.add(new Student("공유",40,100));
		
		System.out.println(hs2); // 공유가 2번 들어감
		// 저장 순서 유지 X, 중복값 그대로 저장 O => 동일객체로 판단이 되지 않았기 때문
		// 값이 추가가 될 때 equals(), hashcode()로 비교 후 둘다 결과가 true면 동일 객체로 판단
		// .equals() & .hashcode() 를 오버라이딩 해야함
		
		// HashSet클래스 안에 객체를 담을 때는 내부적으로 equals()와 hashcode()값이 일치하는지도
		// 비교하기 때문에 둘다 오버라이딩 해야함
		
		// equals() 함수를 실행했을 때 결과 값 true가 나오면서 hashcode()결과값도 일치하면
		// 동일객체로 판단내릴 수 있게끔 재정의 하면 됨
		
		// Object클래스에 있는 equals() : 객체간의 주소값을 가지고 비교
		// Object클래스에 있는 hashcode() : 두 객체의 주소값을 기반으로 해시코드 값을 만들어서 비교
		
		// Student 클래스에 equals() 오버라이딩 : 세 필드값이 동일하면 true/ 하나라도 다르면 false
		// Student 클래스에 hashcode() 오버라이딩 : 세 필드값을 기반으로 해시코드 값 생성
		// Integer => hashcode() : 정수값 그대로 반환
		// String => hashcode() : 문자열기반 해시코드값을 생성 그대로 반환(동일한 문자열 == 동일한 hashcode)
		
		System.out.println("========================================");

		// Set => 객체가 무작위로 저장되어 있음 (index라는 개념이 없음 => 반복문 활용 불가능)
		// 담겨있는 객체에 순차적으로 접근하기 위해선 향상된 반복문 활용
		
		// 1. for문 활용(단, 향상된 for문만 사용 가능 => index로는 접근이 불가능)
		for( Student s : hs2) {
			System.out.println(s);
		}
		
		System.out.println("========================================");
		
		// 2. ArrayList 활용하는 방법
		
		// 2_1. 매개변수 있는 생성자 활용
//		ArrayList<Student> list = new ArrayList(hs2); // hs2에 담겨있는 객체들이 추가된 list가 생성(매개변수에 대입)
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		// 2_2. addAll(Collection c)함수 활용
		ArrayList<Student> list = new ArrayList();
		list.addAll(hs2);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("========================================");
		
		// 3. HashSet 클래스에서 제공하는 Iterator 반복자를 이용하는 방법
		// hs2에 담겨있는 객체들을 Iterator(반복자)에 담는 과정
		Iterator<Student> it = hs2.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		// .iterator() : List계열과 Set계열에서만 사용 가능한 메서드(Map 계열에서는 호출 불가)
		
		
		System.out.println("========================================");
		
		
		// TreeSet : 오름차순 정렬
		
		TreeSet<Integer> set = new TreeSet();
		set.add(500);
		set.add(7);
		set.add(0);
		set.add(100);
		System.out.println(set); // 오름차순 정렬이 알아서 되는 Set
		
		// LinkedHashSet : 순서가 유지됨
		LinkedHashSet<Integer> set2 = new LinkedHashSet();
		set2.add(500);
		set2.add(400);
		set2.add(300);
		set2.add(200);
		set2.add(100);
		System.out.println(set2); // 순서유지가 되는 Set
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
