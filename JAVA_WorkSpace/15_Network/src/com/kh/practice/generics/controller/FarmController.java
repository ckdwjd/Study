package com.kh.practice.generics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.kh.practice.generics.model.vo.Farm;

public class FarmController {
	
	private HashMap<Farm, Integer> hMap = new HashMap();
	private ArrayList<Farm> list = new ArrayList();
	
	public boolean addNewKind(Farm f, int amount) {
		boolean result = hMap.containsKey(f);
		
		if(!result) {
			hMap.put(f, Integer.valueOf(amount));
			return true;
		}
		return false;
	}
	
	public boolean removeKind(Farm f) {
		boolean result = hMap.containsKey(f);
		
		if(result) {
			hMap.remove(f);
			return true;
		}
		return false;
	}
	
	public boolean changeAmount(Farm f, int amount) {
		boolean result = hMap.containsKey(f);
		
		if(result) {
			hMap.replace(f, amount);
			return true;
		}
		return false;
	}
	
	public HashMap<Farm, Integer> printFarm(){
		return hMap;
	}
	
	public boolean buyFarm(Farm f) {
		boolean result = hMap.containsKey(f);

		if (result && hMap.get(f) >= 0) {
			list.add(f);
			hMap.replace(f, hMap.get(f) - 1);
			return true;
		}
		return false;

	}
	
	public boolean removeFarm(Farm f) {
		boolean result = list.contains(f);
		
		Integer amount = hMap.get(f);
		if(result) {
			list.remove(f);
			amount++;
			return true;
		}
		return false;
	}
	
	public ArrayList<Farm> printBuyFarm(){
		return list;
	}

}
