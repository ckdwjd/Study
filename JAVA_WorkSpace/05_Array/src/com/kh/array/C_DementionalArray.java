package com.kh.array;

import java.util.Scanner;

public class C_DementionalArray {
	
	Scanner sc = new Scanner(System.in);
	
	// 이차원 배열 : 일차원 배열 여러개를 하나로 묶은 것

	public void method1() {
		
		// 일차원 배열 선언
		// int[] arr1;
		// int arr2[];

		/*
		 * 이차원 배열 선언
		 * [표현법]
		 * 1. 자료형 배열명[][];
		 * 2. 자료형[][] 배열명;
		 * 3. 자료형[] 배열명[];
		 */
		int arr1[][];
		int[][] arr2;
		int[] arr3[];
		
		/*
		 * 이차원 배열 할당(크기 지정)
		 * 배열명 = new 자료형[행크기][열크기];
		 * 
		 */
		arr3 = new int[2][3];
		
		// 이차원배열 선언과 동시에 할당
		int[][] arr = new int[3][5];
		
		System.out.println(arr);  // 2차원 배열의 주소값 : [[I@6ea6d14e
		System.out.println(arr[0]);  // 1차원 배열의 주소값 : [I@6ad5c04e
		System.out.println(arr[0][0]);  // 0
		
		System.out.println("행의 길이 : " + arr.length);
		// 각 행별 열의 길이를 알고자 한다면
		System.out.println("0행의 열의 크기 : " + arr[0].length);
		System.out.println("1행의 열의 크기 : " + arr[1].length);
		System.out.println("2행의 열의 크기 : " + arr[2].length);
		
		/*
		 * 출력문(arr[0][0]);
		 * 출력문(arr[0][1]);
		 * ...
		 * 출력문(arr[0][4]);
		 * ======================
		 * 출력문(arr[1][0]);
		 * 출력문(arr[1][1]);
		 * ...
		 * 출력문(arr[1][4]);
		 * ======================
		 * 출력문(arr[2][0]);
		 * 출력문(arr[2][1]);
		 * ...
		 * 출력문(arr[2][4]);
		 * 
		 * 
		 */
			for(int i = 0; i < arr.length; i++) {   // 행의 길이 : 0 1 2
				for(int j = 0; j < arr[i].length; j++) {  // 열의 크기 : 0 1 2 3 4
					System.out.printf("arr[%d][%d] : %d\n",i ,j ,arr[i][j] );
				}
				System.out.println();
			}
	}
	
	public void method2() {
		
		// 순서대로 1, 2, 3, 4, 5 ... 15 값을 넣어보기
		
		int[][] arr = new int[3][5];
		
		// 출력식 : printf("%-2d") 
		// 최소 두 칸의 공간을 확보해서 왼쪽에서부터 정렬한 상태
		
		int num = 1;
		for(int i = 0; i < arr.length; i++) {  // 0행 ~ 마지막 행
			for(int j = 0; j < arr[i].length; j++) { // 0열 ~ 각 행별 마지막 열
				arr[i][j] = num++;
				
				System.out.printf("%2d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void method3() {
		
		//일차원 배열 선언 및 할당과 동시에 초기화
		int[] iArr = {1,2,3,4,5};
		
		//이차원 배열 선언 및 할당과 동시에 초기화
		int[][] arr = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
		
		int num = 1;
		for(int i = 0; i < arr.length; i++) {  // 0행 ~ 마지막 행
			for(int j = 0; j < arr[i].length; j++) { // 0열 ~ 각 행별 마지막 열
				arr[i][j] = num++;
				
				System.out.printf("%2d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void method4() {
		/*
		 * 가변 배열
		 * 행의 크기는 정해져있으나 각각의 행 별 열의 갯수가 정해지지 않은 상태
		 * 이차원 배열 == 일차원 배열 여러개 묶은 형태
		 * 즉, 묶어있는 일차원 배열의 길이가 같을 필요는 없다
		 * 행 크기는 생략이 불가능하지만, 열 크기는 생략이 가능하다. 각 행의 열의 길이가 변경 가능하다
		 * 
		 */
		
		int[][] arr = new int[3][];  // 가변 배열, 행은 반드시 정해줘야 함
		
//		System.out.println(arr);  // 이차원 배열의 주소값
//		System.out.println(arr[0]);  // null, 1차원 배열 주소값X(1차원 배열이 비어있기 때문에)
//		System.out.println(arr.length);  // 3
//		System.out.println(arr[0].length);  // 오류 발생 : NullPointerException(null X)
		
		arr[0] = new int[2];
		arr[1] = new int[1];
		arr[2] = new int[3];
		
		/*
		 * 1 2
		 * 3
		 * 4 5 6
		 */
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = value++;
				
				System.out.printf("%d ",arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void method5() {
		
		//char[][] 가변 배열 생성
		char[][] arr = new char[3][];
		// 다음과 같은 문자 행과 열대로 배열에 담기
		/*
		 * a b c
		 * d e
		 * f g h i
		 */
		arr[0] = new char[3];  // 0 1 2
		arr[1] = new char[2];  // 0 1
		arr[2] = new char[4];  // 0 1 2 3
		
		char ch = 'a';
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = ch++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	} 
	
	public void method6() {
		
		// 3행 3열 String[][]배열 생성 후
		// 중첩 반복문을 통해 현재 행, 열의 순번을 출력
		// (0,0) (0,1) (0,2)
		// (1,0) (1,1) (1,2)
		// (2,0) (2,1) (2,2)
		String[][] str = new String[3][3];
		
		for(int i = 0; i < str.length; i++) {
			for(int j = 0; j < str[i].length; j++) {
				System.out.printf("(%d,%d) ",i,j);
			}
			System.out.println();
		}
	}
	
	public void method7() {
		/*
		 * int 형 2차원 배열을 만들어
		 * 0번행 : 국어점수 3개를 입력받기
		 * 1번행 : 영어점수 3개를 입력받은 후
		 * 
		 * 각각 반복문을 통해 출력
		 * 
		 * 입력예시 : xx점수를 입력하세요 :
		 * 출력예시 : xx점수 : xx xx xx
		 */
		int[][] arr = new int[2][3];
		
		for(int i = 0; i < arr.length; i++) {
			String subject = i == 0 ? "국어" : "영어";
			
			for(int j = 0; j < arr[i].length; j++) {
				System.out.printf("%s 점수를 입력하세요 : ", subject);
				arr[i][j] = sc.nextInt();
			}
			System.out.printf("%s 점수 : %d %d %d", subject, arr[i][0], arr[i][1] ,arr[i][2]);
			System.out.println();
//			for(int j = 0; j < arr[i].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
		}
	}
	
	
	
	
	
	
	
	
	
	
}