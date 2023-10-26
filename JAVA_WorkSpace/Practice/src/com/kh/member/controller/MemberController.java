package com.kh.member.controller;

import com.kh.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	
	public int existMemberNum() {
		int count = 0;
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	public Boolean checkId(String inputId) {
		for(Member member : m) {
			if(member != null) {
				if(member.getId().equals(inputId)) {
				return true;
				}
			}
		}
		return false;
	}
	
	public void insertMember(String id, String name, String password, String email, String gender, int age) {
		
	}
	
	public String searchId(String id) {
		
	}
	
	public Member[] searchName(String name) {
	}
	
	public Member[] searchEmail(String email) {
	}
	// 비밀번호 변경 메서드
	public Boolean updatePassword(String id, String password) {
	}
	
	public Boolean updateName(String id, String name) {
	}
	
	public Boolean updateEmail(String id, String email) {
	}
	
	public Boolean delete(String id) {
	}

	public void delete() {
	}
	
	public Member[] printAll() {
	}
	
	
	
}
