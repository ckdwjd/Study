package com.kh.practice.book.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.kh.practice.book.model.dao.BookDao;
import com.kh.practice.book.model.vo.Book;

public class BookController {

	private BookDao bd = new BookDao();
	
	public void makeFile() {
		File file = new File("book.txt");
		
		if (!file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void fileSave(Book[] bArr) {
		bd.fileSave(bArr);
	}
	
	public Book[] fileRead() {
		return bd.fileRead();
		
	}
}
