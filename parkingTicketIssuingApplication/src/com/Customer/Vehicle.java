package com.Customer;

public class Vehicle {
	String type ;
	String reg ;
	String color;
	
	public Vehicle(String type, String reg, String color) {
		super();
		this.type = type;
		this.reg = reg;
		this.color = color;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
