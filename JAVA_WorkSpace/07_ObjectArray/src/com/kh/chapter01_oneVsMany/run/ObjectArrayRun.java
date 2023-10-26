package com.kh.chapter01_oneVsMany.run;

import java.util.Scanner;

import com.kh.chapter01_oneVsMany.model.vo.Book;

public class ObjectArrayRun {

	public static void main(String[] args) {
		
		Book[] arr = new Book[3];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arr.length; i++) {  // i : 0 1 2 
			System.out.print("제목 : ");
			String title = sc.nextLine();
			
			System.out.print("저자 : ");
			String author = sc.nextLine();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			
			arr[i] = new Book(title, author, price, publisher);
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// 사용자에게 검색할 도서 제목을 입력받아
		// 각 전체 도서들의 제목과 일일이 비교하여 일치하는 도서의 가격을 알려주기
		// 만약 일치하는 도서를 찾지 못한경우 : "검색된 도서가 없습니다" 출력
		
		System.out.print("검색할 도서 : ");
		String searchTitle = sc.nextLine();
		boolean isBook  = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getTitle().equals(searchTitle)) {
				isBook = true;
				System.out.println(arr[i].getPrice());
				break;
			}
		}
		if(!isBook) {
			System.out.println("검색된 도서가 없습니다");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
