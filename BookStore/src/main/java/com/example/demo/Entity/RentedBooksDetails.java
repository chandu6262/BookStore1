package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "renteddetails",uniqueConstraints = @UniqueConstraint(name = "renteddetails", columnNames = {"details_id"} ))
public class RentedBooksDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "details_id")
	private int rentedDetails_id;
	
	@Column(name = "issued_quantity")
	private int issuedquantity;
	
	@Column(name = "returned_quantity")
	private int returnedquantity;
	
	@Column(name = "amount")
	private float amount;

	public int getRentedDetails_id() {
		return rentedDetails_id;
	}

	public void setRentedDetails_id(int rentedDetails_id) {
		this.rentedDetails_id = rentedDetails_id;
	}

	public int getIssued_quantity() {
		return issuedquantity;
	}

	public void setIssued_quantity(int issuedquantity) {
		this.issuedquantity = issuedquantity;
	}

	public int getReturned_quantity() {
		return returnedquantity;
	}

	public void setReturned_quantity(int returnedquantity) {
		this.returnedquantity = returnedquantity;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
