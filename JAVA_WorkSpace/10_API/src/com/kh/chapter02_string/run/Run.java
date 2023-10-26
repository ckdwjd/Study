package com.kh.chapter02_string.run;

import com.kh.chapter02_string.controller.A_StringPoolTest;
import com.kh.chapter02_string.controller.B_StringMethodTest;
import com.kh.chapter02_string.controller.C_StringTokenizerTest;
import com.kh.chapter02_string.controller.D_StringBufferAndBuilder;

public class Run {

	public static void main(String[] args) {

		A_StringPoolTest aspt = new A_StringPoolTest();
//		aspt.method1();
		
		B_StringMethodTest bsmt = new B_StringMethodTest();
//		bsmt.method();
		
		C_StringTokenizerTest cstt = new C_StringTokenizerTest();
		cstt.method();
		
		D_StringBufferAndBuilder dsbb = new D_StringBufferAndBuilder();
//		dsbb.method();
		
		
		
	}

}
