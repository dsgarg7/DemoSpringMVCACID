package com.temp.model;

public class Employee {
	
	private String Name;
	private int id;
	private String Designation;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public Employee(String name, int id, String designation) {
		super();
		Name = name;
		this.id = id;
		Designation = designation;
	}

	public Employee() {
		super();
	}

}
