package com.kh.chapter02_abstractAndInterface.part01_basic.model.vo;

public abstract class Sports {
	
	private int people; // 스포츠에 참여하는 선수 인원수
	
	public Sports() {
		
	}

	public Sports(int people) {
		super();
		this.people = people;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Sports [people=" + people + "]";
	}
	
	public abstract void rule();
	
}
