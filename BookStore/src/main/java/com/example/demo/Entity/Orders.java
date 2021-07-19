package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "orders",uniqueConstraints = @UniqueConstraint(name = "orders", columnNames = {"order_id"} ))
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int order_id;

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "total_price")
	private float total_price;
	
	@Column(name = "date_of_order")
	private Date date_of_order;
 
	public Orders() {
		super();
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}

	public Date getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(Date date_of_order) {
		this.date_of_order = date_of_order;
	}

	
}
