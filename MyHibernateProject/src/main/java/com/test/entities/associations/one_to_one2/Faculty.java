package com.test.entities.associations.one_to_one2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="faculty_one_to_one")
public class Faculty {
	
	@Id
	private int faculty_id;
	
	@Column
	private String faculty_name;
	
	@Column
	private String faculty_subject;
	
	@Column
	private Double salary;

	public int getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getFaculty_subject() {
		return faculty_subject;
	}

	public void setFaculty_subject(String faculty_subject) {
		this.faculty_subject = faculty_subject;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
}