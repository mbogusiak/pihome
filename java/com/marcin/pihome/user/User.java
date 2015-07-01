package com.marcin.pihome.user;

public class User {
	String id;
	String firstName;
	String lastName;
	String email;
	int age;
	
	public User(String firstName, String lastName, String email, int age){
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = "3";
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}