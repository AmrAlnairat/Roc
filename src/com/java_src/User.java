package com.java_src;

public class User {
 
 private int id ;
 private String firstName;
 private String middleName;
 private String lastName;
 private String email;
 private String password;
 private String phoneNumber;
 private boolean valid ;
 
 
 
 public User() {
	// TODO Auto-generated constructor stub
}


public User(int id, String firstName, String middleName, String lastName, String phoneNumber, String email, String password) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.middleName = middleName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.phoneNumber = phoneNumber;
}




public User(int id, String firstName, String middleName, String lastName, String email, String phoneNumber) {
	setId(id);
	setFirstName(firstName);
	setMiddleName(middleName);
	setLastName(lastName);
	setEmail(email);
	setPhoneNumber(phoneNumber);
	
	
}


public User(String email,String password,int id) {
	email =   this.email;
	password =this.password;
    id =this.id;
 }






public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getPhoneNumber() {
	return phoneNumber;
}


public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}


public boolean isValid() {
	return valid;
}


public void setValid(boolean valid) {
	this.valid = valid;
}


 

 
 
 
}
