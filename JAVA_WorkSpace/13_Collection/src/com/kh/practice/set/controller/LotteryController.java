package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	
	private HashSet<Lottery> lottery = new HashSet();
	private HashSet<Lottery> win = new HashSet();
	
	public boolean insertObject(Lottery l) {
		 // 방법 1.
		return lottery.add(l);
		
		// 방법 2. 반복문을 활용하는 방법
//		for(Lottery lot : lottery) {
//			if(lot.equals(l)) {
//				return true;
//			}
//			// 방법 2_1.
//			if(lot.hashCode() == l.hashCode()) {
//				return true;
//			}
//		}
//		lottery.add(l);
//		return false;
		
		// 방법 3.
//		int beforeSize = lottery.size();
//		
//		lottery.add(l);
//		
//		int afterSize = lottery.size();
//		if(beforeSize == afterSize) {
//			return true;
//		}
//		return false;
	}
	
	public boolean deleteObject(Lottery l) {
		// 방법 1.
		boolean isTrue = lottery.remove(l);
		
		if(isTrue && win != null) {
			win.remove(l);
		}
		return isTrue;
		
		// 방법 2.
//		boolean result = true;
//		int before = lottery.size();
//		
//		lottery.remove(l);
//		
//		int after = lottery.size();
//		result = before != after;
//		
//		if(result && win != null) {
//			win.remove(l);
//		}
//		return result;
	}
	
	public HashSet winObject() {
		ArrayList<Lottery> list = new ArrayList();
		list.addAll(lottery);
		Collections.shuffle(list);
		// 방법 1.
		if(list.size() < 4) {
			System.out.println("추첨 대상을 추가해주세요.");
			return null;
		} else {
			if(win.size() < 4) {
				for (int i = win.size() ; i < 4; i++) {
					win.add(list.get(i));
				}
			}
			return win;
		}
		// 방법 2.
//		if(list.size() < 4) {
//			return null;
//		}
		
//		while(win.size() < 4) {
//			int randomIndex = (int)(Math.random() * list.size()); //0 <= r <= 4
//			win.add(list.get(randomIndex));
//		}
//		return win;
	}
	
	public TreeSet sortedWinObject() {
		winObject();
		TreeSet<Lottery> ts = new TreeSet(new SortedLottery());
		ts.addAll(win);
		
		return ts;
	}
	
	public boolean searchWinner(Lottery l) {
		// 방법 1.
		boolean isWin = false;
	
		Iterator<Lottery> iter = win.iterator();
		while(iter.hasNext()) {
			Lottery temp = iter.next();
			if(temp.equals(l)) {
				isWin = true;
			}
		}
		return isWin;
		// 방법 2.
//		for(Lottery lot : win) {
//			if(lot.equals(lot)) {
//				return true;
//			}
//		}
//		return false;
	}
}
