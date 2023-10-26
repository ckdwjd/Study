package com.kh.chaper01_beforeVsAfter.before.model.vo;

public class Tv {
	// 브랜드명, 상품코드, 상품명, 가격, 사이즈
	private String brand;
	private String pcode;
	private String pName;
	private int price;
	private int inch;
	
	public Tv() {
		
	}

	public Tv(String brand, String pcode, String pName, int price, int inch) {
		super();
		this.brand = brand;
		this.pcode = pcode;
		this.pName = pName;
		this.price = price;
		this.inch = inch;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
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

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "Tv [brand=" + brand + ", pcode=" + pcode + ", pName=" + pName + ", price=" + price + ", inch=" + inch
				+ "]";
	}
	
}
