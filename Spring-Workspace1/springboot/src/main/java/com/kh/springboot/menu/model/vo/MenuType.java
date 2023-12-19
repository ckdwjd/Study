package com.kh.springboot.menu.model.vo;

import com.fasterxml.jackson.annotation.JsonValue;

/*
 * java.lang.Enum을 상속
 * Enum => Enumeration(열거)의 약자형
 * 기존에 사용하던 상수를 정의하는 방법 중 하나인 static final과 같은 기능을 함
 * 문자열, 숫자들을 나타내는 기본자료형들을 Enum을 통해 표현할 수 있음
 * 
 * Enum을 사용 시 코드가 간결해지고 가독성이 좋아지며 동일한 형태의 데이터그룹을 관리하는데 용이하여 자주사용되는 자료형
 * ex) DB에 저장된 menuType의 값이 KR이든 kr 다 똑같은 값으로써 취급하고 싶을 때 사용, 0 == false == N
 * 
 * public statitc final String type1 = "KR";
 * public statitc final String type2 = "kr";
 * public statitc final String type3 = "korea";
 * 
 * 일반적으로 static final 형태로 데이터를 관리했을 때 상수가 많을수록 가독성이 떨어짐
 * type1, type2, type3 변수명 자체는 의미를 가지지못함
 * 
 */
public enum MenuType {
	
	//static final 예약어 자동추가, 다른 클래스에서 꺼내쓸 때 MenuType.KR, MenuType.CH ... 
	//KR , CH , JP
	
	// KR, CH, JP 각 필드에 비슷한 상수요소 추가
	// 1) 매칭(그룹화)시킬 값을 각 필드에 매개변수로 추가
	KR("kr"), CH("ch"), JP("jp");
	
	// 2) 매개변수로 들어온 값을 저장할 필드 추가
	private String value;
	
	// 3) 생성자 함수 추가 : 각 데이터그룹의 value에는 객체별로 kr,ch,jp 문자열 데이터가 담김
	MenuType(String value) {
		this.value = value;
	}
	
	// 4) getter함수
	@JsonValue
	public String getValue() {
		return value;
	}
	
	// 5-1) 매개변수로 들어온 필드값을 통해 일치하는 Enum을 찾는 메서드1
	public static MenuType menuTypeValueOf(String value) {
		
		switch(value) {
		case "kr" : return KR;
		case "ch" : return CH;
		case "jp" : return JP;
		default : throw new AssertionError("Unknown MenuType : " + value );
				
		}
	}
	
	// 5-2) 매개변수로 들어온 필드값을 통해 일치하는 Enum을 찾는 메서드2
	public static MenuType menuTypeValueOf2(String value) {
		
		// MenuType 내부의 상수객체 배열을 반환(KR, CH, JP)
		MenuType[] menus = MenuType.values();
		
		for(MenuType m : menus) {
			if(m.value == value) { 
				// 반복문 돌리면서 매개변수로 들어온 값과 일치하는 value값을 enum으로 반환
				return m;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
