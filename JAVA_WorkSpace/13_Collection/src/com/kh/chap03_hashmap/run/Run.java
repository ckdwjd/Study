package com.kh.chap03_hashmap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03_hashmap.model.vo.Snack;

public class Run {

	public static void main(String[] args) {
		/*
		 * 계층 구조를 봤을 때 List나 Set계열은 Collection을 구현한 클래스
		 * => 데이터를 추가할 때 공통적으로 add를 사용함
		 * 
		 * 단, Map은 아님
		 * => 데이터를 추가할 때 put메서드 이용(key + value세트로 추가)
		 * 
		 * Map의 특징
		 * 1. key, value 한쌍으로 요소를 구성함
		 * 2. key를 통해서 value를 얻어옴
		 * 3. key는 중복 불가능(value는 중복 가능)
		 * 
		 * 동일한 key로 추가 저장하면, 마지막에 추가한 value값으로 치환(덮어씌우기)
		 * 
		 * !!!!!!!!!!동일한 key값인지 여부는 hashCode()함수로 판단!!!!!!!!!
		 * 
		 */
		
		HashMap<String, Snack> hm = new HashMap();
		
		
		// 1. put(K key, V value) => map공간에 key + value세트로 추가해주는 메서드
		hm.put("다이제", new Snack("초코맛",500));
		hm.put("칸쵸", new Snack("화이트초코맛",300));
		hm.put("도리토스", new Snack("허니칠리맛",600));
		hm.put("프링글스", new Snack("오리지널",300));
		
		System.out.println(hm); // 저장순서 유지 x, value값이 동일해도 key값만 중복되지 않다면 데이터 추가에 문제 x
		
		hm.put("프링글스", new Snack("오리지널",500));
		
		System.out.println(hm); // 마지막으로 선언한 key의 value값으로 덮어씌어짐
		
		
		// 2. get(Object key) : V(제네릭으로 설정한 값) => 컬렉션에서 해당 키값의 value값을 반환해주는 메서드
		System.out.println(hm.get("다이제"));
		
		Snack s = (Snack) hm.get("씬다이제"); // 제네릭 미설정시 반환형 Object클래스(자동형변환 발생 X => 다운캐스팅)
		
		
		// 3. size() => map에 담겨있는 객체의 개수
		System.out.println("size : " + hm.size());
		
		
		// 4. replace(K key, V value) => map에 해당 key값을 찾아서 전달받은 value값으로 변경
		Snack s2 = hm.replace("다이제", new Snack("오리지날",600));
		
		System.out.println(s2); // 바뀌기 이전의 값
		System.out.println(hm);
		
		
		// 5. remove(Object key) => Collection에 해당 key값을 찾아 key + value값을 지워줌
		hm.remove("칸쵸"); // 반환값 : 삭제된 value값 반환
		System.out.println(hm);
		
		
		System.out.println("===================================================");
		
		// 순차적으로 HashMap에 담겨있는 값에 접근하려고 할 때
		// 1. keySet : hashMap에 key값들만 따로 Set에 저장해주는 함수
		// 2. entrySet : key값과 value값을 하나로 묶어서 Set에 담아주는 함수
		
		// for each문 향상된 반복문 사용불가 !!
//		for(Snack s : hm) {
//			
//		}
		// for 기본반복문 사용불가(index개념이 없기 때문에)
		
		// iterator()는 List나 Set계열에서만 사용되는 메서드. 바로사용 불가.
		
		// List와 Map은 다른 계열이기 때문에 ArrayList로 담은 후 출력 불가능
//		ArrayList list = new ArrayList(hm); 
		
		
		
		// Map을 Set으로 바꿔주는 메서드 2개
		// HashMap => Set계열 => set관련 반복문 활용
		
		// 1. keySet()을 이용하는 방법
		System.out.println(hm.keySet()); //[프링글스, 다이제, 도리토스]
		// 1) hm에 있는 key값들만 Set에 담기
		Set<String> keySet = hm.keySet();
		
		// 2) keySet을 iterator에 담기
		Iterator<String> it = keySet.iterator();
		
		// 3) 반복자에 담긴것을 순차적으로 뽑기
		while(it.hasNext()) {
			String key = it.next();
			Snack value = hm.get(key);
			System.out.println("key : " + key);
			System.out.println("value : " + value);
		}
		
		
		// 2. entrySet()을 이용하는 방법
		
		// 1) hm에 있는 key + value 모두 set에 담아둠(Entry == 집합형태)
		Set<Entry<String, Snack>> entrySet = hm.entrySet();
//		ArrayList<Entry<String, Snack>> list = new ArrayList(entrySet);
//		System.out.println(list);
		
		// 2) entrySet에 있는 것들을 Iterator에 담기
		Iterator<Entry<String, Snack>> itEntry = entrySet.iterator();
		
		// 3) 반복자를 이용해서 순차적으로 값을 뽑기
		while(itEntry.hasNext()) {
			Entry<String, Snack> entry = itEntry.next();
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
