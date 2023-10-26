package com.kh.hw.person.controller;

import com.kh.hw.person.model.vo.Employee;
import com.kh.hw.person.model.vo.Student;

public class PersonController {

	private Student[] s = new Student[3];
	private Employee[] e = new Employee[10];
	
	public int[] personCount() {
		int[] count = new int[2];
		
		for(int i = 0; i < s.length; i++) {
			if(s[i] != null) {
				count[0] += 1;
			}
		}
		for(int i = 0; i < e.length; i++) {
			if(e[i] != null) {
				count[1] += 1;
			}
		}
		return count;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		Student student = new Student(name, age, height, weight, grade, major);
		
		for(int i = 0; i < s.length; i++) {
			if(s[i] == null) {
				s[i] = student;
				break;
			}
		}
	}
	
	public Student[] printStudent() {
		
		return s;
	}
	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		Employee employee = new Employee(name, age, height, weight, salary, dept);
		
		for(int i = 0; i < e.length; i++) {
			if(e[i] == null) {
				e[i] = employee;
				break;
			}
		}
	}
	
	public Employee[] printEmployee() {
		
		return e;
	}
}
