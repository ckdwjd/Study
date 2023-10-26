package com.kh.chapter01_poly.part02_electronic.controller;

import com.kh.chapter01_poly.part02_electronic.model.vo.Desktop;
import com.kh.chapter01_poly.part02_electronic.model.vo.NoteBook;
import com.kh.chapter01_poly.part02_electronic.model.vo.Tablet;

// 다형성을 적용시키기 전
public class ElectronicController1 {
	
	// 용산 전자상가에 새로 오픈한 가게
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	
	public void insert(Desktop d) {
		desk = d;
	}
	public void insert(NoteBook n) {
		note = n;
	}
	//오버로딩 : 메소드명이 같이도 매개변수가 달라서 사용 가능
	public void insert(Tablet t) {
		tab = t;
	}
	
	public Desktop selectDesktop() {
		return desk;
	}
	
	// 매개변수가 똑같기 때문에 오버로딩 불가, 메소드명을 따로 지어줘야 함
	public NoteBook selectNoteBook() {
		return note;
	}
	
	public Tablet selectTablet() {
		return tab;
	}
	
	
	
	
	
	
	
	
	
}
