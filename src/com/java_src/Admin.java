package com.java_src;

public class Admin extends User {
    
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Admin(int id, String firstName, String middleName, String lastName, String phoneNumber, String email,
			String password) {
		super(id, firstName, middleName, lastName, phoneNumber, email, password);
		// TODO Auto-generated constructor stub
	}


	public Admin(String email, String password, int id) {
		super(email, password, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}

	@Override
	public String getMiddleName() {
		// TODO Auto-generated method stub
		return super.getMiddleName();
	}

	@Override
	public void setMiddleName(String middleName) {
		// TODO Auto-generated method stub
		super.setMiddleName(middleName);
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}


	@Override
	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return super.getPhoneNumber();
	}


	@Override
	public void setPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		super.setPhoneNumber(phoneNumber);
	}


	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return super.isValid();
	}


	@Override
	public void setValid(boolean valid) {
		// TODO Auto-generated method stub
		super.setValid(valid);
	}
 
	
	
	
	
	
	
	
	
	
	
	
}
