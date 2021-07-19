package com.example.demo.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "rent",uniqueConstraints = @UniqueConstraint(name = "rent", columnNames = {"rental_id"} ))
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	private int rental_id;
	
	@Column(name = "issued_date")
	private Date issued_date;
	
	@Column(name = "returned_date")
	private Date returned_date;
	
	@Column(name = "amount")
	private float amount;
	
	@OneToMany(targetEntity = RentedBooksDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "rental_id", referencedColumnName = "rental_id")
	private List<RentedBooksDetails> details;

	public int getRental_id() {
		return rental_id;
	}

	public void setRental_id(int rental_id) {
		this.rental_id = rental_id;
	}

	public Date getIssued_date() {
		return issued_date;
	}

	public void setIssued_date(Date issued_date) {
		this.issued_date = issued_date;
	}

	public Date getReturned_date() {
		return returned_date;
	}

	public void setReturned_date(Date returned_date) {
		this.returned_date = returned_date;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public List<RentedBooksDetails> getDetails() {
		return details;
	}

	public void setDetails(List<RentedBooksDetails> details) {
		this.details = details;
	}
	

}