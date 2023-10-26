package com.kh.member.view;

import java.util.Scanner;

import com.kh.member.controller.MemberController;
import com.kh.member.model.vo.Member;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);

	private MemberController mc = new MemberController();

	public MemberMenu() {

	}

	public void mainMenu() {

		while (true) {
			System.out.println("최대 등록 가능한 회원 수는 " + MemberController.SIZE + "명입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");
			if (mc.existMemberNum() != 10) {
				System.out.println("1. 새 회원 등록");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");

			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			sc.nextLine();

			switch (num) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
			}
		}
	}

	public void insertMember() {
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			if(mc.checkId(id)) {
				System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
				continue;
			}
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			
			System.out.print("이메일 : ");
			String email = sc.nextLine();
			
			String gende = "";
			while(true) {
				System.out.print("성별 : ");
				String gender = sc.nextLine();
				char temp = gender.toLowerCase().charAt(0);
				if(!(temp == 'M' || temp == 'F')) {
					System.out.println("성별을 다시 입력하세요");
				}
				break;
			}
			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			mc.insertMember(id, name, password, email, gender, age);
			break;
		}
	}

	public void searchMember() {
	}

	public void searchId() {
	}

	public void searchName() {
	}

	public void searchEmail() {
	}

	public void updateMember() {
	}

	public void updatePassword() {

	}

	public void updateName() {

	}

	public void updateEmail() {

	}

	public void deleteMember() {
	}

	public void deleteOne() {
	}

	public void deleteAll() {
	}

	public void printAll() {
	}

}
