package com.kh.chapter02_abstractNinterface.controller;

import com.kh.chapter02_abstractNinterface.model.vo.GalaxyNote9;
import com.kh.chapter02_abstractNinterface.model.vo.Phone;
import com.kh.chapter02_abstractNinterface.model.vo.SmartPhone;
import com.kh.chapter02_abstractNinterface.model.vo.V40;

public class PhoneController {

	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] phone = new Phone[2];
		
		phone[0] = new GalaxyNote9();
		phone[1] = new V40();
		
		for(int i = 0; i < phone.length; i++) {
			if(phone[i] instanceof GalaxyNote9) {
				result[i] = ((SmartPhone)phone[i]).printInformation();
				
			}
			if(phone[i] instanceof V40) {
				result[i] = ((SmartPhone)phone[i]).printInformation();
			}
		}
		return result;
	}
}
