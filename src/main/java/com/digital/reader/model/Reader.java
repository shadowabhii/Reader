package com.digital.reader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Integer rId;
	private String firstName;
	private String lastName;
	private int age;
	private String userName;
	private String password;
	private String emailId;
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Reader(Integer rId, String firstName, String lastName, int age, String userName, String password,
			String emailId) {
		super();
		this.rId = rId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
	}
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Reader [rId=" + rId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", userName=" + userName + ", password=" + password + ", emailId=" + emailId + "]";
	}
	


}
