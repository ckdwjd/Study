package com.kh.chapter02_abstractNinterface.run;

import com.kh.chapter02_abstractNinterface.controller.PhoneController;

public class Run {

	public static void main(String[] args) {
		
		String[] pc = new PhoneController().method();
		for(int i = 0; i < pc.length; i++) {
			System.out.println(pc[i]);
			System.out.println();
		}

	}

}
