package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberView;

/*
 * Controller : View를 통해서 요청(request)한 기능을 처리 담당
 * 				해당 메서드로 전달된 데이터들을 가공처리(VO 객체로 랩핑)한 후 Service메서드 호출 시 전달
 * 				Service로 부터 반환받은 결과에 따라 사용자가 보개돨 화면을 지정 => 응답(response)
 * 
 */

public class MemberController {

	private MemberService ms = new MemberService();
	
	/**
	 * 사용자의 회원 추가 요청을 처리해주는 메서드
	 * @param m : 회원의 정보가 담긴 객체
	 */
	public void insertMember(Member m) {
		
		// 1. 전달받은 userId, userPwd, userName ... 정보를 가지고 Member 객체에 담기
		
		// 2. Dao의 InsertMember메서드 호출하기
		int result = ms.insertMember(m);
		
		// result = 0 => 데이터 추가 실패
		// result = 1 => 데이터 삽입 성공
		
		// 3. 결과값에 의해서 사용자가 보게될 화면(response)를 지정
		if (result > 0) { // 성공 시
			// 성공메세지를 띄워주는 화면 호출
			new MemberView().displaySuccess("회원 추가 성공");
			
		} else { // 실패 시
			// 실패메세지를 띄워주는 화면 호출
			new MemberView().displayFail("회원 추가 실패");
			
		}
	}

	/**
	 * 사용자의 회원 전체 조회 요청을 처리해주는 메서드
	 */
	public void selectAll() {
		
		// 결과값을 담을 변수
		// SELECT -> ResultSet -> ArrayList<Member>
		
		ArrayList<Member> list = ms.selectAll();
		
		// 조회 결과 여부 판단 후 사용자가 보게될 응답화면을 지정
		if(list.isEmpty()) { // 빈 리스트일 경우 => 조회결과가 없음
			
			new MemberView().displayNodata("전체 조회 결과가 없습니다.");
			
		} else { // 조회됬을 경우 => 조회결과 있음
			
			new MemberView().displayList(list);
			
		}
	}
	
	/**
	 * 사용자의 아이디로 검색 요청을 처리해주는 메서드
	 * @param userId : 사용자가 입력했던 검색하고자 하는 아이디
	 * @author 오창정
	 */
	public void selectByUserId(String userId) {
		
		// 결과값을 담을 변수
		// SELECT => ResultSet => Member
		Member m = ms.selectByUserId(userId);
		
		// 조회결과 여부 판단 후 사용자가 보게될 화면을 지정
		if(m == null) { // 조회결과가 없는 경우
			
			new MemberView().displayNodata(userId + "에 해당하는 검색 결과가 없습니다.");
			
		} else { // 조회결과가 있는 경우
			
			new MemberView().displayOne(m);
			
		}
	}
	
	
	public void selectByUserName(String keyword) {
		
		ArrayList<Member> list = ms.selectByUserName(keyword);
		
		if(list.isEmpty()) {
			
			new MemberView().displayNodata(keyword + "에 해당하는 검색 결과가 없습니다.");
			
		} else {
			
			new MemberView().displayList(list);
			
		}
	}
	
	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
		
		// 넘겨받은 값을 가지고 VO객체로 랩핑
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = ms.updateMember(m);
		
		if(result > 0) {
			
			new MemberView().displaySuccess("회원 정보 변경 성공");
			
		} else {
			
			new MemberView().displayFail(userId + "에 해당하는 검색 결과가 없습니다.");
			
		}
	}
	
	public void deleteMember(String userId, String userPwd) {
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		int result = ms.deleteMember(m);
		
		if(result > 0) {
			
			new MemberView().displaySuccess("성공적으로 탈퇴되었습니다.");
			
		} else {
			
			new MemberView().displayFail(userId + "에 해당하는 검색 결과가 없습니다.");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
