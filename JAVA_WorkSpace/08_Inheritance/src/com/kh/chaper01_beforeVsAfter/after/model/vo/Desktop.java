package com.kh.chaper01_beforeVsAfter.after.model.vo;

			// 자식 			 // 부모
			// 후손			 // 조상
			// 하위			 // 상위
public class Desktop extends Product{
	// 브랜명, 코드명, 상품명, 가격, 패키지
	
	private boolean allInOne;
	
	public Desktop() {
//		super();   // JVM이 자동으로 생성
	}
	
	public Desktop(String brand, String pCode, String pName, int price, boolean allInOne) {
		// super : 부모의 메모리 영역상 주소값,  super(); 부모 기본 생성자
		// 부모객체에 생성된 필드데이터를 자식객체에서 초기화 시켜주는 방법?
		// 해결방법 - 주로 1번 ,3번을 사용
		// 1. 부모 클래스에 있는 public접근제한자를 가진 setter이용하기
		//	  부모 클래스 안에 있는 setBrand함수 호출하기
//		super.setBrand(brand);
//		super.setpCode(pCode);
//		super.setpName(pName);
//		super.setPrice(price);
		
		// 2. 부모클래스의 필드에 직접 접근해서 초기화 -> 부모클래스의 접근제한자를 protected로 변경
//		super.brand = brand;
		
		// 3. 부모 생성자 호출하기(항상 첫줄에 부모생성자를 호출해야함) : super();
		super(brand, pCode, pName, price);
		
		this.allInOne = allInOne;
	}

	public boolean isAllInOne() {
		return allInOne;
	}

	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}

	// 오버라이딩 : 부모클래스의 메소드를 자식 클래스가 재정의하는 것
	@Override
	public String toString() {
		return "Desktop [allInOne=" + allInOne + ", toString()=" + super.toString() + "]";
	}

	
			
}
