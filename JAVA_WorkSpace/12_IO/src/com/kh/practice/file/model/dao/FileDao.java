package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDao {
	
	public boolean checkName(String file) {
		return new File(file).isFile();
		// true => file임, 즉 생성되어 있음
		// false => file이 아니거나 생성되어 있지 않음
	}
	
	public void fileSave(String file, String s) {
		
		try(FileWriter fw = new FileWriter(file)) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder sb = new StringBuilder();
		
		try(FileReader fr = new FileReader(file)){
			
			int value = 0;
			while((value = fr.read()) != -1) {
				sb.append((char)value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}
	
	public void fileEdit(String file, String s) {
		try(FileWriter fw = new FileWriter(file,true)) {
			fw.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
