package com.kh.practice.score.controller;

import java.io.DataInputStream;
import java.io.FileNotFoundException;

import com.kh.practice.score.model.dao.ScoreDao;

public class ScoreController {
	
	private ScoreDao sd = new ScoreDao();
	
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		sd.saveScore(name, kor, eng, math, sum, avg);
	}
	
	public DataInputStream readScore() throws FileNotFoundException {
		return sd.readScore();
	}

}
