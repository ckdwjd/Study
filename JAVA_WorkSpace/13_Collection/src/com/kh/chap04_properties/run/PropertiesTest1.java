package com.kh.chap04_properties.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap03_hashmap.model.vo.Snack;

public class PropertiesTest1 {

	public static void main(String[] args) {
		// Properties : Map계열 -> key + value 세트로 저장
		//				단, Properties만의 특징 : key, value 모두 String으로 제한
		//				파일 입출력 메서드를 지원, 설정정보 표현에 최적의 형태를 가짐
		Properties prop = new Properties();
		
		// String이 아닌 값을 넣게될 경우, Map계열이기 때문에 추가 가능
		prop.put("다이제", new Snack());
		
		System.out.println(prop);
		System.out.println(prop.get("다이제"));
		
		// 단, 주로 Properties를 사용하는 경우 Properties에 담겨있는 key + value를 세트로 파일에 기록함
		// 그리고 파일에 기록된 key + value를 가지고 올때 주로 사용
		
//		try {
//			prop.store(new FileOutputStream("test.properties"), "Properties test");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// String 값이 아니기에 에러 발생
		
		
		// 따라서 Properties에 값을 담을 때 보통
		// 1. setProperty(String key, String value)
		prop = new Properties();
		
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet, TreeSet, LinkedHashSet");
		prop.setProperty("Map", "HashMap, Properties");
		
		System.out.println(prop); // 저장순서 유지 x, key값 중복 
		
		
		// 값 가져오기
		// 2. getProperty(String key) : String
		System.out.println(prop.getProperty("Map"));
		System.out.println(prop.getProperty("DBID")); // null
		System.out.println(prop.getProperty("DBID","HEY")); // 두번째 매개변수는 받고자 하는 값이 없을 때 default값을 제시가능
		
		
		try {
			// 3. store(출력스트림객체, 코멘트 내용) : Properties안에 담긴 key, value를 파일로 출력
			prop.store(new FileOutputStream("test.properties"), "ABC");
			
			// 4. storeToXML(출력스트림객체, 코멘트내용) : Properties안에 담긴 key, value값을 XML문서로 출력
			prop.storeToXML(new FileOutputStream("test.xml"), "xml");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
