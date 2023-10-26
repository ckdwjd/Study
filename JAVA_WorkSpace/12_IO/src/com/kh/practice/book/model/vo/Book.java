package com.kh.practice.book.model.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book implements Serializable{
	

	private String title;
	private String author;
	private int price;
	private Calendar date;
	private double discount;
	
	public Book() {
		
	}

	public Book(String title, String author, int price, Calendar date, double discount) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.date = date;
		this.discount = discount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		
		// date 클래스 객체 생성 후
		// SimpleDateFormat 매개변수로 데이트 객체 넣어주기
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String formatDate = sdf.format(new Date(date.getTimeInMillis()));
				
		
		return title +"\t" + author +"\t"+ price +"\t"+ date.get(Calendar.YEAR) +"년 "+ date.get(Calendar.MONTH) +"월 " + date.get(Calendar.DATE)+"일   " + discount;
	}
	
	
}
