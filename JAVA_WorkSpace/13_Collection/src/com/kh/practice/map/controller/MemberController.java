package com.kh.practice.map.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.kh.practice.map.model.vo.Member;

public class MemberController {

	private HashMap<String, Member> map = new HashMap();
	
	public boolean joinMembership(String id, Member m) {
		
		if(map.get(id) == null) {
			map.put(id, m);
			return true;
		}
		return false;
	}
	
	public String logIn(String id, String password) {
		boolean result = map.containsKey(id);
		
		if(result) {
			if(map.get(id).getPassword().equals(password)) {
				return map.get(id).getName();
			}
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		boolean result = false;
		
		if(map.containsKey(id) && map.get(id).getPassword().equals(oldPw)) {
			map.replace(id, new Member(newPw, map.get(id).getName()));
			result = true;
		}
		return result;
		
//		Member m = map.get(id);
//		if(m != null && m.getPassword().equals(oldPw)) {
//			m.setPassword(newPw);
//			return true;
//		}
//		return false;
	}
	
	public void changeName(String id, String newName) {
//		map.replace(id, new Member(map.get(id).getPassword(), newName));
		map.get(id).setName(newName);
	}
	
	public TreeMap sameName(String name) {
		TreeMap<String, String> tMap = new TreeMap();
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			Member value = map.get(key);
			if(value.getName().equals(name)) {
				tMap.put(key, value.getName());
			}
		}
		return tMap;
	}
}
