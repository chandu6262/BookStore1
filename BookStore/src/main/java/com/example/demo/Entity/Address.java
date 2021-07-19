package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address",uniqueConstraints = @UniqueConstraint(name = "address", columnNames = {"address_id"} ))
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int address_id;

	@Column(name = "Hno")
	private int Hno;

	@Column(name = "street")
	private String street;

	@NotNull(message = "city is required")
	@Column(name = "city")
	private String city;

	@NotNull(message = "State is required")
	@Column(name = "state")
	private String state;

	@NotNull(message = "Pincode is required")
	@Column(name = "pincode")
	private int pincode;

	public Address() {
		super();
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getHno() {
		return Hno;
	}

	public void setHno(int hno) {
		Hno = hno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


}
