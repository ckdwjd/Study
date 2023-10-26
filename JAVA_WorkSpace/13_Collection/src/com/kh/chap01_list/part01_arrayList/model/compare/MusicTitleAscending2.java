package com.kh.chap01_list.part01_arrayList.model.compare;

import java.util.Comparator;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class MusicTitleAscending2 implements Comparator<Music>{
	
	// 가수 기준 오름차순
	
	@Override
	public int compare(Music s1, Music s2) {
		/*
		 * 양수 : 자리유지
		 * 0 : 자리유지
		 * 음수 : 자리바꿈
		 */
		return s1.getArtist().compareTo(s2.getArtist());
	}

}
