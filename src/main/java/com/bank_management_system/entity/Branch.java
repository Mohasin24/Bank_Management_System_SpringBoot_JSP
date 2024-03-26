package com.bank_management_system.entity;


import jakarta.persistence.*;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	private String name;
	
	private String state;
	
	private String city;

	public Branch() {
	}

	public Branch(String name, String state, String city) {
		this.name = name;
		this.state = state;
		this.city = city;
	}

	public Branch(int id, String name, String state, String city) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.city = city;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Branch{" +
				"id=" + id +
				", name='" + name + '\'' +
				", state='" + state + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
