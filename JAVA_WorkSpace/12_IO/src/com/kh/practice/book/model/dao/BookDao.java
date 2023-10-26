package com.kh.practice.book.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.practice.book.model.vo.Book;

public class BookDao {

private Book[] bArr = new Book[10];
	
	public void fileSave(Book[] bArr) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.txt"))) {
//			for(int i = 0; i < bArr.length; i++) {
//				if(bArr[i] != null) {
//					oos.writeObject(bArr[i]);
//				}
//			}
			if (bArr != null) {
				oos.writeObject(bArr);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Book[] fileRead() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.txt"))){
				bArr = (Book[])ois.readObject();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return bArr;
	}
}
