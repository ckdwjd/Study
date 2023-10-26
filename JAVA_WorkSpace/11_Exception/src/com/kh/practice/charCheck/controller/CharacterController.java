package com.kh.practice.charCheck.controller;

import com.kh.practice.charCheck.exception.CharCheckException;

public class CharacterController {
	
	CharCheckException cce = new CharCheckException();
	
	public CharacterController() {
		
	}
	
	public int countAlpha(String s) throws CharCheckException{
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.toUpperCase().charAt(i) >= 'A' && s.toUpperCase().charAt(i) <= 'Z') {
				count++;
			}
			if(s.contains(" ")) {
				throw new CharCheckException("체크할 문자열 안에 공백이 포함되어 있습니다.");
			}
		}
		return count;
	}
}
