package com.simplysoft.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long id;
	private String studentName;
	private String studentAddress;
	private int studentClass;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String studentName, String studentAddress, int studentClass) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.studentClass = studentClass;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", studentAddress=" + studentAddress
				+ ", studentClass=" + studentClass + "]";
	}
	
	
}
