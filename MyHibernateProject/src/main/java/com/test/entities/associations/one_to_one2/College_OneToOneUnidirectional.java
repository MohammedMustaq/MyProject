package com.test.entities.associations.one_to_one2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="College_one_to_one")
public class College_OneToOneUnidirectional {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column
	private String type;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="faculty_id", referencedColumnName="faculty_id")
	private Faculty faculty;

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	
	
}