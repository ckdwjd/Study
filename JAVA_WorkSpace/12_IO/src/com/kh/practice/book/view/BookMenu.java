package com.kh.practice.book.view;

import java.util.Calendar;
import java.util.Scanner;

import com.kh.practice.book.controller.BookController;
import com.kh.practice.book.model.vo.Book;

public class BookMenu {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private Book[] bArr;
	
	public BookMenu() {
		bc.makeFile();
		bArr = bc.fileRead();
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 도서 추가 저장");
			System.out.println("2. 저장 도서 출력");
			System.out.println("9. 프로그램 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
			case 1:
				fileSave();
				break;
			case 2:
				fileRead();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default :
				System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void fileSave() {
		System.out.print("도서 명 : ");
		String title = sc.nextLine();
		
		System.out.print("저자 명 : ");
		String author = sc.nextLine();
		
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("출판 날짜(yyyy-mm-dd) : ");
		String cal = sc.nextLine();
		int year = Integer.parseInt(cal.split("-")[0]);
		int month = Integer.parseInt(cal.split("-")[1]);
		int day = Integer.parseInt(cal.split("-")[2]);
		
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
		
		System.out.print("할인율 : ");
		double discount = sc.nextDouble();
		sc.nextLine();
		
		Book book = new Book(title, author, price, date, discount);
		
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i] == null) {
				bArr[i] = book;
				break;
			}
		}
		bc.fileSave(bArr);
	}

	public void fileRead() {
//		String str = "";
//		for(int i = 0; i < bc.fileRead().length; i++) {
//			if(bc.fileRead()[i] != null) {
//				System.out.println(bc.fileRead()[i]);
//			}
//		}
		Book[] books = bc.fileRead();
		for(Book b : books) {
			if(b != null) {
				System.out.println(b);
			}
		}
	}
}
