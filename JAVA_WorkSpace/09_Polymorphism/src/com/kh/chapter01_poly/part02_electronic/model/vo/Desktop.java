package com.kh.chapter01_poly.part02_electronic.model.vo;

public class Desktop extends Electronic {
	
	public static final String CPU = "intel";
	
	private String grahpic;
	
	public Desktop() {
		
	}

	public Desktop(String brand, String name, int price, String grahpic) {
		super(brand, name, price);
		this.grahpic = grahpic;
	}

	public String getGrahpic() {
		return grahpic;
	}

	public void setGrahpic(String grahpic) {
		this.grahpic = grahpic;
	}

	@Override
	public String toString() {
		return super.toString() + "Desktop [grahpic=" + grahpic + "]";
	}
	
	
	
	
	
}
