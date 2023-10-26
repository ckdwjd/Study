package com.kh.practice.dimention;

import java.util.Arrays;
import java.util.Scanner;

public class DimentionPractice {

	Scanner sc = new Scanner(System.in);

	public void practice1() {

		String[][] str = new String[3][3];

		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length; j++) {
				System.out.printf("(%d, %d)", i, j);
			}
			System.out.println();
		}
	}

	public void practice2() {

		int[][] arr = new int[4][4];

		int num = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice3() {

		int[][] arr = new int[4][4];

		int num = 16;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num--;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice4() {

		int[][] arr = new int[4][4];

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length - 1; j++) {
				arr[i][j] = (int) (Math.random() * 10 + 1);

				arr[i][arr[i].length - 1] += arr[i][j];
				arr[arr.length - 1][j] += arr[i][j];

				arr[arr.length - 1][arr[i].length - 1] += arr[i][j] * 2;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice5() {

		System.out.print("행 크기 : ");
		int height = sc.nextInt();

		System.out.print("열 크기 : ");
		int width = sc.nextInt();

		char[][] ch = new char[height][width];

		if (width > 0 && width < 10 || height > 0 && height < 10) {
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					ch[i][j] = (char) (Math.random() * 26 + 65);

					System.out.print(ch[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("반드시 1 ~ 10 사이의 정수를 입력해야 합니다.");
			practice5();
			return;
		}
	}

	public void practice6() {

		String[][] strArr = new String[][] { { "이", "까", "왔", "앞", "힘" }, { "차", "지", "습", "으", "냅" },
				{ "원", "열", "니", "로", "시" }, { "배", "심", "다", "좀", "다" }, { "열", "히", "! ", "더", "!! " } };

		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr[i].length; j++) {

				System.out.print(strArr[j][i] + " ");
			}
			System.out.println();
		}
	}

	public void practice7() {

		System.out.print("행의 크기 : ");
		int size = sc.nextInt();

		char[][] arr = new char[size][];

		char ch = 'a';
		for (int i = 0; i < size; i++) {
			System.out.printf("%d행의 열 크기 : ", i);
			arr[i] = new char[sc.nextInt()];

			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ch++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void practice8() {
		
		String[] str = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", 
				"차천축", "피풍표", "홍하하"};
		
		String[][] class1 = new String[3][2];
		String[][] class2 = new String[3][2];
		
		int index = 0;
		System.out.println("== 1분단 ==");
		for(int i = 0; i < class1.length; i++) {
			for(int j = 0; j < class1[i].length; j++) {
				class1[i][j] = str[index++];
				System.out.print(class1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("== 2분단 ==");
		for(int i = 0; i < class2.length; i++) {
			for(int j = 0; j < class2[i].length; j++) {
				class2[i][j] = str[index++];
				System.out.print(class2[i][j] + " ");
			}
			System.out.println();
		}
	}
}
