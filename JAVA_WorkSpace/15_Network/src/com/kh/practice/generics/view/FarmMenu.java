package com.kh.practice.generics.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.kh.practice.generics.controller.FarmController;
import com.kh.practice.generics.model.vo.Farm;
import com.kh.practice.generics.model.vo.Fruit;
import com.kh.practice.generics.model.vo.Nut;
import com.kh.practice.generics.model.vo.Vegetable;

public class FarmMenu {

	private Scanner sc = new Scanner(System.in);
	private FarmController fc = new FarmController();
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		
		while(true) {
			System.out.println("****** 메인 메뉴 ******");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void adminMenu() {
		while(true) {
			System.out.println("****** 직원 메뉴 ******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정");
			System.out.println("4. 농산물 목록");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				addNewKind();
				break;
			case 2:
				removeKind();
				break;
			case 3:
				changeAmount();
				break;
			case 4:
				printFarm();
				break;
			case 9:
				System.out.println("메뉴으로 돌아가기");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void customerMenu() {
		System.out.println("현재 KH마트 농산물 수량");
		printFarm();
		
		while(true) {
			System.out.println("****** 고객 메뉴 ******");
			System.out.println("1. 농산물 사기");
			System.out.println("2. 농산물 뺴기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기");
			System.out.print("메뉴 번호 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				buyFarm();
				break;
			case 2:
				removeFarm();
				break;
			case 3:
				printBuyFarm();
				break;
			case 9:
				System.out.println("메뉴으로 돌아가기");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addNewKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("추가할 종류 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		String kind = "";
		switch(num) {
		case 1:
			kind = "Fruit";
			break;
		case 2:
			kind = "Vegetable";
			break;
		case 3:
			kind = "Nut";
			break;
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			addNewKind();
		}

		System.out.print("수량 : ");
		int amount = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1:
			Fruit fr = new Fruit(kind, name);
			if(fc.addNewKind(fr, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
		case 2:
			Vegetable ve = new Vegetable(kind, name);
			if(fc.addNewKind(ve, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
		case 3:
			Nut nu = new Nut(kind, name);
			if(fc.addNewKind(nu, amount)) {
				System.out.println("새 농산물이 추가되었습니다.");
				break;
			} else {
				System.out.println("새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");
				addNewKind();
			}
		}
	}

	public void removeKind() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("삭제할 종류 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		String kind = "";
		switch(num) {
		case 1:
			kind = "Fruit";
			break;
		case 2:
			kind = "Vegetable";
			break;
		case 3:
			kind = "Nut";
			break;
		default : 
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeKind();
		}
		
		switch(num) {
		case 1:
			Fruit fr = new Fruit(kind, name);
			if(fc.removeKind(fr)) {
				System.out.println("농산물 삭제를 성공하였습니다.");
				break;
			} else {
				System.out.println("농산물 삭제를 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
		case 2:
			Vegetable ve = new Vegetable(kind, name);
			if(fc.removeKind(ve)) {
				System.out.println("농산물 삭제를 성공하였습니다.");
				break;
			} else {
				System.out.println("농산물 삭제를 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
		case 3:
			Nut nu = new Nut(kind, name);
			if(fc.removeKind(nu)) {
				System.out.println("농산물 삭제를 성공하였습니다.");
				break;
			} else {
				System.out.println("농산물 삭제를 실패하였습니다. 다시 입력해주세요.");
				removeKind();
			}
		}
	}
	
	public void changeAmount() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("변경할 종류 번호 : ");
		int num = Integer.parseInt(sc.nextLine());

		System.out.print("이름 : ");
		String name = sc.nextLine();

		System.out.print("수정할 수량 : ");
		int amount = Integer.parseInt(sc.nextLine());
		
		String kind = "";
		switch(num) {
		case 1:
			kind = "Fruit";
			break;
		case 2:
			kind = "Vegetable";
			break;
		case 3:
			kind = "Nut";
			break;
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			changeAmount();
		}
		
		switch(num) {
		case 1:
			Fruit fr = new Fruit(kind, name);
			if(fc.changeAmount(fr, amount)) {
				System.out.println("수량 수정을 성공하였습니다.");
				break;
			} else {
				System.out.println("수량 수정을 실패하였습니다. 다시 입력해주세요.");
				changeAmount();
			}
		case 2:
			Vegetable ve = new Vegetable(kind, name);
			if(fc.changeAmount(ve, amount)) {
				System.out.println("수량 수정을 성공하였습니다.");
				break;
			} else {
				System.out.println("수량 수정을 실패하였습니다. 다시 입력해주세요.");
				changeAmount();
			}
		case 3:
			Nut nu = new Nut(kind, name);
			if(fc.changeAmount(nu, amount)) {
				System.out.println("수량 수정을 성공하였습니다.");
				break;
			} else {
				System.out.println("수량 수정을 실패하였습니다. 다시 입력해주세요.");
				changeAmount();
			}
		}
	}
	
	public void printFarm() {
		HashMap<Farm, Integer> hMap = fc.printFarm();
		Set<Farm> keySet = hMap.keySet();
		
		Iterator<Farm> it = keySet.iterator();
		
		while(it.hasNext()) {
			Farm key = it.next();
			Integer value = hMap.get(key);
			System.out.println(key + " (" + value + "개)");
		}
	}
	
	public void buyFarm() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("구매할 종류 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(!(num == 1 || num == 2 || num == 3)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			buyFarm();
		}
		
		System.out.print("구매할 농산물 이름 : ");
		String name = sc.nextLine();
		
		String kind = "";
		switch(num) {
		case 1:
			kind = "Fruit";
			break;
		case 2:
			kind = "Vegetable";
			break;
		case 3:
			kind = "Nut";
			break;
		}
		
		switch(num) {
		case 1:
			kind = "fruit";
			Fruit fr = new Fruit(kind, name);
			if(fc.buyFarm(fr)) {
				System.out.println("구매에 성공하였습니다.");
				break;
			} else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
				buyFarm();
			}
		case 2:
			kind = "Vegetable";
			Vegetable ve = new Vegetable(kind, name);
			if(fc.buyFarm(ve)) {
				System.out.println("구매에 성공하였습니다.");
				break;
			} else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
				buyFarm();
			}
		case 3:
			kind = "Nut";
			Nut nu = new Nut(kind, name);
			if(fc.buyFarm(nu)) {
				System.out.println("구매에 성공하였습니다.");
				break;
			} else {
				System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
				buyFarm();
			}
		}
	}
	
	public void removeFarm() {
		System.out.println("1. 과일 / 2. 채소 / 3. 견과");
		System.out.print("구매취소할 농산물 번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.print("제거할 농산물 이름 : ");
		String name = sc.nextLine();
		
		if(!(num == 1 || num == 2 || num == 3)) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			removeFarm();
		}
		String kind = "";
		switch(num) {
		case 1:
			kind = "Fruit";
			break;
		case 2:
			kind = "Vegetable";
			break;
		case 3:
			kind = "Nut";
			break;
		}
		switch(num) {
		case 1:
			kind = "fruit";
			Fruit fr = new Fruit(kind, name);
			if(fc.removeFarm(fr)) {
				System.out.println("구매 취소에 성공하였습니다.");
				break;
			} else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
				removeFarm();
			}
		case 2:
			kind = "Vegetable";
			Vegetable ve = new Vegetable(kind, name);
			if(fc.removeFarm(ve)) {
				System.out.println("구매 취소에 성공하였습니다.");
				break;
			} else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
				removeFarm();
			}
		case 3:
			kind = "Nut";
			Nut nu = new Nut(kind, name);
			if(fc.removeFarm(nu)) {
				System.out.println("구매 취소에 성공하였습니다.");
				break;
			} else {
				System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
				removeFarm();
			}
		}
	}
	
	public void printBuyFarm() {
		ArrayList<Farm> list = fc.printBuyFarm();
		Iterator<Farm> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

