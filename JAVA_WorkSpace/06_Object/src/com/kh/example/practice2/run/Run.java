package com.kh.example.practice2.run;

import com.kh.example.practice2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		
		Product apple = new Product();
		apple.setpName("IPHONE14");
		apple.setPrice(1500000);
		apple.setBrand("APPLE");
		
		apple.information();
		
	}

}
