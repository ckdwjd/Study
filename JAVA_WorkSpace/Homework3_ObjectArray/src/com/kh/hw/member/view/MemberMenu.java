package com.kh.hw.member.view;

import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;
import com.kh.hw.member.model.vo.Member;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	
	private MemberController mc = new MemberController();
	
	public MemberMenu() {
		
	}
	
	public void mainMenu() {
		while(true) {
			int num = mc.existMemberNum();
			System.out.println("최대 등록 가능한 회원 수는 " + MemberController.SIZE + "명입니다.");
			System.out.println("현재 등록된 회원 수는 " + num + "명입니다.");
			
			if(num != 10) {
				System.out.println("1. 새 회원 등록");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 2 :
				searchMember();
				break;
			case 3 :
				updateMember();
				break;
			case 4 :
				deleteMember();
				break;
			case 5 :
				printAll();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				return;
			case 1 :    // 사용할 수 없는 상태일때 defualt문 실행
				if(num != 10) {
					insertMember();
					break;
				}
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			
			
			}
		}
	}
	
	public void insertMember() {
		System.out.println("새 회원을 등록합니다.");
		while(true) {
			
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			if(mc.checkId(id)) {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
				continue;
			}
			
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			
			String gender = "";
			while(true) {
				System.out.print("성별(M/F) : ");
				gender = sc.nextLine();
				char temp = gender.toUpperCase().charAt(0); // toUpperCase : 입력받은 문자를 모두 대문자로 변경
				if(temp == 'M' || temp == 'F') {
					break;
				}
			}
			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			mc.insertMember(id, name, password, email, gender, age);
			break;
		}
	}
	
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		sc.nextLine();
		
		switch(menuNum) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}
	
	public void searchId() {
		System.out.print("검색할 아이디 : ");
		String id = sc.nextLine();
		String searchId = mc.searchId(id);

		if (searchId == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(searchId);
		}
	}
	
	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		Member[] m = mc.searchName(name);

		if (m == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member member : m) {
				if(member != null) {
					System.out.println(member);
				}
			}
		}
	}
	
	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String email = sc.nextLine();
		Member[] m = mc.searchEmail(email);

		if (m == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member member : m) {
				if(member != null) {
					System.out.println(member);
				}
			}
		}
	}
	
	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		sc.nextLine();
		
		switch(menuNum) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}
	
	public void updatePassword() {
		System.out.print("수정할 아이디 : ");
		String id = sc.nextLine();
		
		System.out.print("수정할 비밀번호 : ");
		String password = sc.nextLine();
		
		if(mc.updatePassword(id, password)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
			
		}
		
	}
	
	public void updateName() {
		
	}
	
	public void updateEmail() {
		
	}
	
	public void deleteMember() {
		System.out.println("1. 특정회원 삭제하기");
		System.out.println("2. 모든회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		
		System.out.print("메뉴 번호 : ");
		int menuNum = sc.nextInt();
		sc.nextLine();
		
		switch(menuNum) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}
	
	public void deleteOne() {
		System.out.println("정말 삭제하시겠습니까?(Y/N) : ");
		char ch = sc.nextLine().toUpperCase().charAt(0); // 대문자로만 받음
		if(ch == 'Y') {
			System.out.print("삭제할 아이디 : ");
			String id = sc.nextLine();
			if(mc.delete(id)) {
				System.out.println("성공적으로 삭제하였습니다.");
				
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}
	
	public void deleteAll() {
		mc.delete();
	}
	
	public void printAll() {
		Member[] m = mc.printAll();
		int count = mc.existMemberNum();
		if(count == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}
		for( Member member : m ) {
			if(member != null) {
				System.out.println(member);
			}
		}
	}
	
	
	
	
	
	
}
