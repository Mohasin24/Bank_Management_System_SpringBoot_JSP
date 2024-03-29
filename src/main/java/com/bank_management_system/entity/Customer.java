package com.bank_management_system.entity;


import jakarta.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	private int branchId; 
	
	private String password;
	
    private String firstName;
	
	private String lastName;
	
	private String dob;
	
	private String gender;
	
	private String presentAddress;
	
	private String permentAddress;
	
	private String phoneNumber;
	
	private String emailId;
	
	private String date;

	public Customer() {
	}

	public Customer(int branchId, String password, String firstName, String lastName, String dob, String gender, String presentAddress, String permentAddress, String phoneNumber, String emailId, String date) {
		this.branchId = branchId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.presentAddress = presentAddress;
		this.permentAddress = permentAddress;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.date = date;
	}

	public Customer(int id, int branchId, String password, String firstName, String lastName, String dob, String gender, String presentAddress, String permentAddress, String phoneNumber, String emailId, String date) {
		this.id = id;
		this.branchId = branchId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.presentAddress = presentAddress;
		this.permentAddress = permentAddress;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermentAddress() {
		return permentAddress;
	}

	public void setPermentAddress(String permentAddress) {
		this.permentAddress = permentAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", branchId=" + branchId +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dob='" + dob + '\'' +
				", gender='" + gender + '\'' +
				", presentAddress='" + presentAddress + '\'' +
				", permentAddress='" + permentAddress + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", emailId='" + emailId + '\'' +
				", date='" + date + '\'' +
				'}';
	}
}
