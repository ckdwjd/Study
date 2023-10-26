package com.kh.hw.member.controller;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;
	
	public int existMemberNum() {
		int count = 0;
		for( Member member : m ) {
			if(member != null) {
				count++;
			}
		}
		return count;
	}
	
	public Boolean checkId(String inputId) {
		
		for( Member member : m ) {
			if(member != null) {
				if(member.getId().equals(inputId)) {
					return true;
				}
			}
		}
		return false;  // false를 반환하는 이유
	}
	
	public void insertMember(String id, String name, String password, String email, String gender, int age) {
		
//		m[existMemberNum()] = new Member(id , name , password , email , gender.charAt(0) , age);

		Member member = new Member(id , name , password , email , gender.charAt(0) , age);
		// 첫번째 방법
		for(int i = 0; i < m.length; i++) {
			if(m[i] == null) {
				m[i] = member;
				break;
			}
		}
	}
	
	public String searchId(String id) {
		
		for( Member member : m ) {
			if(member != null) {
				if(id.equals(member.getId())){
					return member.toString();
				}
			}
		}
		return null;
	}
	
	public Member[] searchName(String name) {
		Member[] m2 = new Member[SIZE];
		int index = 0;
		for(Member member : m) {
			if(member != null) {
				if(name.equals(member.getName())) {
					m2[index++] = member;
				}
			}
		}
		return m2;
	}
	
	public Member[] searchEmail(String email) {
		Member[] m2 = new Member[SIZE];
		int index = 0;
		for(Member member : m) {
			if(member != null) {
				if(email.equals(member.getEmail())) {
					m2[index++] = member;
				}
			}
		}
		return m2;
	}
	// 비밀번호 변경 메서드
	public Boolean updatePassword(String id, String password) {
		
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(id.equals(m[i].getId())) {
					m[i].setPassword(password);
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean updateName(String id, String name) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(id.equals(m[i].getId())) {
					m[i].setName(name);
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean updateEmail(String id, String email) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(id.equals(m[i].getId())) {
					m[i].setEmail(email);
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean delete(String id) {
		for(int i = 0; i < m.length; i++) {
			if(m[i] != null) {
				if(id.equals(m[i].getId())) {
					m[i] = null;
					return true;
				}
			}
		}
		return false;
	}

	public void delete() {
		m = new Member[SIZE];
	}
	
	public Member[] printAll() {
		return m;
	}
	
	
	
}
