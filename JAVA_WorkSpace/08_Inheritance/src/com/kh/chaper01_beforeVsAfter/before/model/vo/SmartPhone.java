package com.kh.chaper01_beforeVsAfter.before.model.vo;

public class SmartPhone {
	// 브랜드, 상품코드, 상품명, 가격, 통신사
	
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	private String mobileAgendy;
	
	public SmartPhone() {
		
	}

	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgendy) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.mobileAgendy = mobileAgendy;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMobileAgendy() {
		return mobileAgendy;
	}

	public void setMobileAgendy(String mobileAgendy) {
		this.mobileAgendy = mobileAgendy;
	}

	@Override
	public String toString() {
		return "SmartPhone [brand=" + brand + ", pCode=" + pCode + ", pName=" + pName + ", price=" + price
				+ ", mobileAgendy=" + mobileAgendy + "]";
	}
	
	
	
}
