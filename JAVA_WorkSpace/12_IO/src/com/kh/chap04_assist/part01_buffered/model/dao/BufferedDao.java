package com.kh.chap04_assist.part01_buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {

	// BufferedReader / BufferedWriter
	
	// 프로그램 -> 파일
	public void fileSave() {
		// 1. 기반스트림 객체 먼저 생성
		// 보조스트림도 Reader/Writer 계열이면 기반스트림도 Reader/Writer 계열이여야 한다
		// 보조스팀도 Input/Output 계열이면 기반스트림도 Input/Output 계열이여야 한다
		
		BufferedWriter bw = null;
		try {
			//FileWriter fw = new FileWriter("c_buffer.txt");
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			
			bw.write("안녕하세요");
			bw.newLine(); // 개행문자를 넣어주는 메서드 
			bw.write("반갑다\n");
			bw.write("수고하셨어요");
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close(); // 기반 스트림은 닫아주지 않고 보조 스트림만 닫는다
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// try ~ with ~ resource구문(jdk7 버전 이상부터 가능)
		/*
		 * try(스트림객체 생성;){
		 * 		// 예외가 발생될법한 구문
		 * } catch(예외클래스명 e) {
		 * 		//예외 발생 시 실행할 구문
		 * }
		 *
		 * 스트림객체를 try()안에 넣어버리면 스트림 객체 생성 후 해당 블록구문이 실행이 완료된 후 알아서 자원이 반납됨
		 */
	}
	
	// 프로그램 <-- 외부매체
	public void fileRead() {
		
		// FileReader
		// BufferedReader
		
		try(BufferedReader br = new BufferedReader(new FileReader("C_buffer.txt"))){
			
			String value = null;
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
