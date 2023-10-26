package com.kh.chapter02_override.model.vo;

public class Book /*extends Object*/{

	// 제목, 저자, 가격
	private String title;
	private String author;
	private int price;
	
	// 기본 생성자, 매개변수 생성자, getter/setter
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	/*
	 * 오버라이딩
	 * - 상속받고 있는 부모클래스의 메소드를 자식클래스에서 재정의 하는 것
	 * - 부모가 제공하고 있는 메소드를 자식이 일부 고쳐서 사용하겠다는 의미, 실행시 자식메소드가 우선권을 가짐
	 * 
	 * 오버라이딩 성립 조건
	 * - 부모메서드의 메서드명과 동일
	 * - 매개변수 자료형, 갯수, 순서가 동일(매개변수이름 상관없음)
	 * - 반환형 동일
	 * - 부모메서드의 접근제한자보다 같거나 공유범위가 더 커야한다
	 * ex) 부모 메서드의 접근제한자가 protected라면 자식은 public, protected여야 함
	 * => 최소한 위 조건을 모두 지켜야 오버라이딩이 성립
	 * 
	 * @Override 어노테이션?
	 * - 생략가능(명시를 안해도 부모메서드와 형태가 같으면 오버라이딩 된 것)
	 * - 어노테이션을 붙이는 이유?(붙이는게 관례)
	 *   > 잘못 기술했을 경우 오류를 알려주기 때문에 다시한번 검토할 수 있게 해줌
	 *   > 부모메서드가 나중에 수정되었을 경우 오류로 알려주기 때문에 검토할 수 있게 해줌
	 *   > 이 메서드가 오버라이딩된 메서드라는걸 알리는게 목적(제일 중요)
	 *   
	 * 
	 */
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	
	
	
	
}
