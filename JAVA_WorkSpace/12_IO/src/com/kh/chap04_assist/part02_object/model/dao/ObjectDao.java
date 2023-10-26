package com.kh.chap04_assist.part02_object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04_assist.part02_object.model.vo.Phone;

public class ObjectDao {

	public void fileSave(String fileName) {
	
		// Phone ph = new Phone("아이폰",1500000,"안보임");
		// 길이 3인 객체배열 선언
		Phone[] arr = new Phone[3];
		arr[0] = new Phone("아이폰12",1500000,"안보임");
		arr[1] = new Phone("아이폰13",2000000,"안보임");
		arr[2] = new Phone("아이폰14",2500000,"안보임");
		/*
		 * 객체단위를 파일에 출력하고자 할 때 필요한 스트림
		 * FileOutputStream : 파일에 데이터를 출력하는 "기반"스트림
		 * ObjectOutputStream : 객체단위로 출력을 보조해주는 보조 스트림
		 */
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			
			//oos.writeObject(ph);
			for(int i = 0; i < arr.length; i++) {
				oos.writeObject(arr[i]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void fileRead() {
		
		// FileInputStream : 파일로부터 데이터를 읽어들이기 위해 사용되는 기반 스트림
		// ObjectInputStream : 스트림으로 부터 객체 단위로 입력받기 위해 사용되는 보조 스트림
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phone.txt"))) {
			
			// phone 객체는 object를 상속받기 때문에 강제 형변환
			
			while(true) {
				Phone p = (Phone)ois.readObject();
				System.out.println(p);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) { // End Of File의 약자, IOException의 부모이기 떄문에 다형성에 걸림 따라서 앞에 배치해야함
			System.out.println("파일을 다 읽었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void fileSave1(String fileName) {
		
		Phone[] p = new Phone[3];
		
		ObjectOutputStream oos = null;
		
		try {
			oos =  new ObjectOutputStream(new FileOutputStream(fileName));
			
			for(Phone pp : p) {
				oos.writeObject(pp);
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
