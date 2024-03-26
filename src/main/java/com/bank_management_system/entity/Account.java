package com.bank_management_system.entity;

import jakarta.persistence.*;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	private String accountNo;
	
	private int pin;
	
	private int customerId;
	
	private String date;
	
	private double balance;
	
	private String type;
	
	private String status;

	public Account() {
	}
	public Account(String accountNo, int pin, int customerId, String date, double balance, String type, String status, String password) {
		this.id = id;
		this.accountNo = accountNo;
		this.pin = pin;
		this.customerId = customerId;
		this.date = date;
		this.balance = balance;
		this.type = type;
		this.status = status;

	}

	public Account(int id, String accountNo, int pin, int customerId, String date, double balance, String type, String status, String password) {
		this.id = id;
		this.accountNo = accountNo;
		this.pin = pin;
		this.customerId = customerId;
		this.date = date;
		this.balance = balance;
		this.type = type;
		this.status = status;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", accountNo='" + accountNo + '\'' +
				", pin=" + pin +
				", customerId=" + customerId +
				", date='" + date + '\'' +
				", balance=" + balance +
				", type='" + type + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
