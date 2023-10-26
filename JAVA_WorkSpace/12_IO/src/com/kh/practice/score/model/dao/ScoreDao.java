package com.kh.practice.score.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScoreDao {

	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("Score.txt",true))) {
//			dos.writeUTF(name);
//			dos.writeInt(kor);
//			dos.writeInt(eng);
//			dos.writeInt(math);
//			dos.writeInt(sum);
//			dos.writeDouble(avg);
//			dos.flush(); // 데이터 입력이 제대로 안될 때 입력
			
			String data = name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg;
			dos.writeUTF(data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DataInputStream readScore() throws FileNotFoundException{
		DataInputStream dis = new DataInputStream(new FileInputStream("Score.txt"));
		return dis;
	}
}
