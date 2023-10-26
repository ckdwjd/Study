package com.kh.chapter01_poly.part02_electronic.run;

import com.kh.chapter01_poly.part02_electronic.controller.ElectronicController2;
import com.kh.chapter01_poly.part02_electronic.model.vo.Desktop;
import com.kh.chapter01_poly.part02_electronic.model.vo.Electronic;
import com.kh.chapter01_poly.part02_electronic.model.vo.NoteBook;
import com.kh.chapter01_poly.part02_electronic.model.vo.Tablet;

public class Run {

	public static void main(String[] args) {
		
		// 납품업체
		
		// 1. 다형성을 적용하지 않은 케이스(ElectronicController1)
//		ElectronicController1 ec = new ElectronicController1();
//		
//		ec.insert(new Desktop("삼성","데탑",1200000,"지포스1070"));
//		ec.insert(new NoteBook("엘지","그램",2000000,4));
//		ec.insert(new Tablet("애플","아이패드",500000,true));
//		
//		// 가게에 있는 제품 조회
//		System.out.println(ec.selectDesktop());
//		System.out.println(ec.selectNoteBook());
//		System.out.println(ec.selectTablet());
		
		// 2. 다형성 적용했을 경우(ElectronicController2)
		ElectronicController2 ec = new ElectronicController2();
		
		ec.insert(new Desktop("삼성","데탑",1200000,"지포스1070"), 0);
		ec.insert(new NoteBook("엘지","그램",2000000,4), 1);
		ec.insert(new Tablet("애플","아이패드",500000,true), 2);
		
		Electronic[] elec = ec.select();
		
		for(Electronic e: elec ) {
			System.out.println(e);
		}
		
		/*
		 * 
		 * 다형성을 사용하는 이유
		 * 1. 생산성울 위해서(코드를 적게 사용)
		 * 2. 부모타입의 객체배열로 다양한 자식들을 받아줄 수 있음
		 * 		=> 부모타입 하나만으로 모든 자식객체들을 다룰 수 있음
		 * 3. 메소드의 매개변수나 반환형에도 다형성을 적용할 수 있음
		 * 		=> 메소드 갯수가 줄어듬
		 * 
		 */
		
		
	}

}
