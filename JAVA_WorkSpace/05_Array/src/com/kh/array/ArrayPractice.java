package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 10 - i ;
			System.out.print(arr[i] + " ");
		}
		for(int i = arr.length - 1; i >= 0; i--) {
			arr[i] = i + 1 ;
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice2() {
		
		System.out.print("양의 정수 : ");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice3() {
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice4() {
		
		String[] day = {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};

		System.out.print("0 ~ 6 사이 숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num >= day.length) {
			System.out.println("잘못 입력하셨습니다.");
		}
		for(int i = 0; i < day.length; i++) {
			if(num == i) {
				System.out.println(day[i]);
			}
		}
	}
	
	public void practice5() {
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		int[] arr = new int[num];
		for(int i = 0; i < arr.length; i++) {
			sc.nextLine();
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ",i);
			int input = sc.nextInt();
			
			arr[i] = input;
			sum += input;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n총합 : " + sum);
	}
	
	public void practice6() {
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] ch = new char[str.length()];
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i); // [a ,p ,p l, i, c, a, t, i, o, n]
		}
		int count = 0;
		
		System.out.print("문자열에 있는 문자 : ");
		
		loop1:
		for(int i = 0; i < ch.length; i++) {
			boolean isDuplicate = false;
			loop2:
			for(int j = 0; j < i; j++) {
				if(ch[i] == ch[j]) {
					isDuplicate = true;
					break;
				}
			}
			if(!isDuplicate) {
				System.out.print(ch[i] + (i == (ch.length - 1) ? "" : ", "));
				count++;
			}
		}
		System.out.println("\n 문자 개수 : " + count);
	}
	
	public void practice7() {
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] ch = new char[str.length()];
		
		System.out.print("문자 : ");
		char cha = sc.nextLine().charAt(0);
		
		int sum = 0;
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
			if(ch[i] == cha) {
				sum += 1;
			}
		}
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ", str, cha);
		for(int i = 0; i < ch.length; i++) {
			if(cha == ch[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.printf("\n%c 개수 : %d",cha ,sum);
	}
	
	public void practice8() {
		
		System.out.print("주민등록번호(-포함) : ");
		String id = sc.nextLine();
		
		char[] str = new char[id.length()];
		
		for(int i = 0; i < str.length; i++) {
			str[i] = id.charAt(i);
		}
		char[] copy = new char[str.length];
		
		System.arraycopy(str, 0, copy, 0, 13);
		
		for(int i = 8; i < str.length; i++) {
			copy[i] = '*';
		}
		for(int i = 0; i < str.length; i++) {
			System.out.print(copy[i]);
		}
	}
	
	public void practice9() {
		
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			} else if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최솟값 : " + min);
	}
	
	public void practice10() {
		
		int[] arr = new int[10];
		
		int[] checkArr = new int[11];
		
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 10 + 1);
			if(checkArr[random] == 1) {
				i--;  // 다음i 조건에서 검사하기 때문에 i값 1감소시키기
				continue;
			}
			arr[i] = random;
			checkArr[random] = 1;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice11() {
		
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		if(num < 0 || num % 2 != 1 || num < 3) {
			System.out.println("다시 입력하세요.");
			practice11();
			return;
		}
		int[] arr = new int[num];
		
		int half = num / 2 + 1;
		for(int i = 0; i < arr.length; i++) {
			if(i < half) {
				arr[i] = i+1;
			} else if(i >= half)
			arr[i] = num - i;
			
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] arr = new String[size];
		String[] copy = null;
		
		int i = 0;
		while(true){
			if(i == size) {
				System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
				char ch = sc.nextLine().charAt(0);
				if(ch == 'y' || ch == 'Y') {
					System.out.print("더 입력하고 싶은 개수 : ");
					int num = sc.nextInt();
					sc.nextLine();
					
					//arr배열은 꽉참, 따라서 카피본 배열을 생성해야함
					copy = new String[size + num];
					size += num;
					for(int j = 0; j < arr.length; j++) {
						copy[j] = arr[j];
					}
					arr = copy;
				}else {
					break;
				}
			}
			System.out.printf("%d번째 문자열 : ",i+1);
			arr[i] = sc.nextLine();
			i++;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void practice6_1() {
		
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] ch = new char[str.length()];
		
		int num = 0;
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
		}
		System.out.print("문자열에 있는 문자 : ");
		for(int i = 0; i < ch.length; i++) {
			boolean isOverlap = false;
			
			for(int j = 0; j < i; j++) {
				if(ch[i] == ch[j]) {
					isOverlap = true;
					break;
				}
			}
			if(!isOverlap) {
				num++;
				System.out.print(ch[i] + " " + (i == (ch.length - 1) ? " " : ", "));
			}
		}
		System.out.println("\n문자 개수 : " + num);
		System.out.println();
	}
	
	public void practice10_1() {
		
		int[] arr = new int[10];
		
		int[] checkArr = new int[11];

		for (int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 10 + 1);
			if (checkArr[random] == 1) {
				i--;
				continue;
			}
			arr[i] = random;
			checkArr[random] = 1;
		}
		System.out.print(Arrays.toString(arr));
	}
	
	
	
}
