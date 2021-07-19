package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "books",uniqueConstraints = @UniqueConstraint(name = "books", columnNames = {"book_id"} ))

public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int book_id;
	
	@Column(name = "book_name")
	private String book_name;
	
	@Column(name = "price")
	private float price;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
	private List<User> user = new ArrayList<>();
    
	@OneToMany(targetEntity = Rent.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	private List<Rent> rent;

	@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	private List<Orders> order;

	@OneToMany(targetEntity = RentedBooksDetails.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	private List<RentedBooksDetails> details;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Rent> getRent() {
		return rent;
	}

	public void setRent(List<Rent> rent) {
		this.rent = rent;
	}

	public List<Orders> getOrder() {
		return order;
	}

	public void setOrder(List<Orders> order) {
		this.order = order;
	}

	public List<RentedBooksDetails> getDetails() {
		return details;
	}

	public void setDetails(List<RentedBooksDetails> details) {
		this.details = details;
	}

}

