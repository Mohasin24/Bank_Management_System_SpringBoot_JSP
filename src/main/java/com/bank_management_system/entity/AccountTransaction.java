package com.bank_management_system.entity;


import jakarta.persistence.*;

@Entity
public class AccountTransaction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	private int accountId;
	
	private int toAccountId;
	
	private String type;
	
	private double amount;
	
	private String date;

	public AccountTransaction() {
	}

	public AccountTransaction(int accountId, int toAccountId, String type, double amount, String date) {
		this.accountId = accountId;
		this.toAccountId = toAccountId;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public AccountTransaction(int id, int accountId, int toAccountId, String type, double amount, String date) {
		this.id = id;
		this.accountId = accountId;
		this.toAccountId = toAccountId;
		this.type = type;
		this.amount = amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}

	@Override
	public String toString() {
		return "AccountTransaction{" +
				"id=" + id +
				", accountId=" + accountId +
				", toAccountId=" + toAccountId +
				", type='" + type + '\'' +
				", amount=" + amount +
				", date='" + date + '\'' +
				'}';
	}
}
