package com.kh.chaper01_beforeVsAfter.after.model.vo;

public class SmartPhone extends Product{
	// 브랜드, 상품코드, 상품명, 가격, 통신사
	
	private String mobileAgendy;
	
	public SmartPhone() {
		
	}

	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgendy) {
		super(brand, pCode, pName, price);
		this.mobileAgendy = mobileAgendy;
	}

	public String getMobileAgendy() {
		return mobileAgendy;
	}

	public void setMobileAgendy(String mobileAgendy) {
		this.mobileAgendy = mobileAgendy;
	}

	@Override
	public String toString() {
		return "SmartPhone [mobileAgendy=" + mobileAgendy + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
