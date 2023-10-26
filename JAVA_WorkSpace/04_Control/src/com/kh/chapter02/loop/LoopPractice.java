package com.kh.chapter02.loop;

import java.util.Scanner;

public class LoopPractice {
	
	//Scanner sc = new Scanner(System.in); 각 메서드 내에 입력하지 않아도 됨
	
	public void practice1() {
//		사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요. 
//		단, 입력한 수는 1보다 크거나 같아야 합니다. 만일, 1 미만의 숫자가 입력됐다면
//		“1 이상의 숫자를 입력해주세요”가 출력되면서 다시 사용자가 값을 입력하도록 하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1 이상의 숫자를 입력해주세요 : ");
		int num = sc.nextInt();
//		
//		if(num > 0 ) {
//			for(int i = 1; i <= num; i++) {  // 1 2 3 4 5 ... n
//				System.out.print(i + " ");
//			}
//		} else {
//			System.out.println("1 이상의 숫자를 입력해주세요.");
//			practice1();
//			return;
//		}
		
		if(!(num > 0)) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			practice1();
			return;
		}
		for(int i = 1; i <= num; i++) {  // 1 2 3 4 5 ... n
			System.out.print(i + " ");
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int num = sc.nextInt();
		
//		if(num > 0) {
//			for(int i = num; i > 0; i--) {
//				System.out.print(i + " ");
//			}
//		} else {
//			System.out.println("1이상의 숫자를 입력하세요.");
//			practice2();
//			return;
//		}
		
		if(!(num > 0)) {
			System.out.println("1이상의 숫자를 입력하세요.");
			practice2();
			return;
		}
		for(int i = num; i > 0; i--) {
			System.out.print(i + " ");
		}
	}
	
	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int num = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i <= num; i++) {
			sum += i;
			System.out.print(i);
			if(i != num) {
				System.out.print(" + ");
			} else {
				System.out.print(" = ");
			}
//			System.out.print(i + (i == num ? " = " : " + "));
		} 
		
		System.out.print(sum);
	}
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1 <= 0 || num2 <= 0){
			System.out.println("1 이상의 숫자를 입력해주세요.");
			practice4();
			return;
		} 
//		if(num1 < num2){
//			for(int i = num1; i <= num2; i++) {
//				System.out.print(i + " ");
//			}
//		} else {
//			for(int i = num2; i <= num1; i++) {
//				System.out.print(i + " ");
//			}
//		}
		int min = num1;
		if(min > num2) {
			min = num2;
		}
		int max = num1;
		if(max < num2) {
			max = num2;
		}
		for(int i = min; i <= max; i++) {
			System.out.print(i + " ");
		}
	}
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num > 9) {
			System.out.println("9 이하의 숫자만 입력해주세요.");
			practice5();
			return;
		}
		for(int i = num; i <= 9; i++) {
			System.out.println("====" + i + "단" + "====");
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %d \n",i , j ,i , j);
			}
		}
	}

	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작 숫자 : ");
		int num = sc.nextInt();
		
		System.out.print("공차 : ");
		int gap = sc.nextInt();
		
//		for(int i = 1; i <= 10; i ++) {
//			System.out.print(num + " ");
//			num += gap;
//		}
		System.out.println();
		for(int i = num; i <= num + gap * 9; i += gap) {
			System.out.print(i + " ");
		}
	}
	
	public void practice7() {
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {  //무한반복
			System.out.print("연산자(+, -, *, /, %) : ");
			String op = sc.nextLine();
			
			if(op.equals("exit")){
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			
			sc.nextLine();
			
			int result = 0;
			
			switch(op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if(num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					practice7();
					return;
				}
				result = num1 / num2;
				break;
			case "%":
				if(num2 == 0) {
					System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
					practice7();
					return;
				}
				result = num1 % num2;
				break;
			default : 
				System.out.println("없는 연산자 입니다. 다시 입력해주세요.");
				practice7();
				return;
			}
			System.out.printf("%d %s %d = %d \n", num1, op, num2, result);
		}
	}
	
	public void practice8() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (i >= j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j = num; j >= 1; j--) {
				if(j >= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j = num; j >= 1; j--) {
				if (j <= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
//		for(int i =0; i < num; i++) {
//			for(int j = 0; j < num; j++) {
//				if(j < (num - 1) - i) {
//					System.out.print(" ");
//				} else {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
	}
	
	public void practice11() {

		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num = sc.nextInt();

		for (int i = num; i >= 1; i--) {
			for (int j = num; j >= 1; j--) {
				if (i >= j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j = num * 2 - 1; j >= 1; j--) {
				if(j < (num + i) && j  > (num - i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		int x = 0;
		
		if(num == 0) {
			System.out.println("잘못 입력했습니다.");
			practice13();
			return;
		}
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				x++;
			}
		}
		if(x == 2) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}
	}
	
	public void practice14() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		
		if(num < 2) {
			System.out.println("잘못 입력했습니다.");
			practice14();
			return;
		}
		int count = 0;
		
		for(int i = 2; i <= num; i++) {  // i : 2 3 4 5 6 7 8 ...
			//'소수'는 i를 1부터 i까지로 나눴을 때 나누어 떨어지는 수가 1과 i뿐인 수를 말
			boolean isPrime = true;  // 소
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {  //소수가 아닌 케이스
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.printf("\n2부터 %d까지 소수의 개수는 %d개입니다.",num , count);
	}
	
	public void practice15() {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("자연수 하나를 입력하새요 : ");
		int num = sc.nextInt();
		
		int count = 0;
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				System.out.print(i + " ");
			}
			if(i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("count : " + count);
	}
	
	public void practice16() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num * 2 - 1; i++) {
			for(int j = 1; j <= num; j++) {
				if(j <= i && i <= num) {
					System.out.print("*");
				}
				if(i > num && i < j + num ) {
					System.out.print("*"); 
				}
			}
			System.out.println();
		}
	}
	
	public void practice17() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num + (num - 1); i++) {
			for(int j = 1; j <= num; j++) {
				if(i == 1 || i == num) {
					System.out.print("*");
				}
				if(i > 1 && i < num) {
					System.out.print((j == 1 || j == num) ? "*" : " ");
				}
			}
			System.out.println();
		}
	}
	
	public void practice18() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num * 3 + 1 ; i++) {
			for(int j = 1; j <= num * 2 - 1; j++) {
				if(j < (num - i) + 1 || j > (num - 1) + i) {
					System.out.print(" ");
				} else if(i > num * 2 - 1){
					if(j < i - (i - j) + 1 ) {
						System.out.print(" ");
					}
				} else {
					System.out.print("*");
					
				}
				 
			}
			System.out.println();
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
