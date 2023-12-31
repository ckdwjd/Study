package com.kh.chap04_assist.part02_object.model.vo;

import java.io.Serializable;
/*
 * 직렬화할 수 있는 인터페이스(Serializable)
 * 
 * 객체단위로 입출력 해주는 스트림에서 사용되어질 객체는 반드시 "Serializable"을 구현해야한다
 * 그렇지 않으면 NotSerializableException이 발생함
 * 
 */
public class Phone implements Serializable{
	/*
	 * 클래스별 고유 번호
	 */
	private static final long serialVersionUID = 1L; // 있든 없든 차이는 없음

	private String name;
	private int price;
	// transient 객체 입출력스트림에서 해당 값을 전송하지 않음
	private transient String hidden;
	
	public Phone() {
		
	}
	
	public Phone(String name, int price, String hidden) {
		super();
		this.name = name;
		this.price = price;
		this.hidden = hidden;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	
}
