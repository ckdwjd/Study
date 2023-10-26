package com.kh.example.practice4.run;

import com.kh.example.practice4.model.vo.Student;

public class Run {

	public static void main(String[] args) {

		Student oh = new Student();
		oh.setGrade(3);
		oh.setClassroom(6);
		oh.setGender('남');
		oh.setHeight(180.5);
		oh.setName("오창정");
		oh.information();
	}

}
