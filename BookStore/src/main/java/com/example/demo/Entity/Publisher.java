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
@Table(name = "publisher",uniqueConstraints = @UniqueConstraint(name = "publisher", columnNames = {"publisher_id"} ))
public class Publisher {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "publisher_id")
	private int publisher_id;
	
	@Column(name = "publisher_name")
	private String publisher_name;
	
	@Column(name = "date_of_birth")
	private Date date_of_birth;
	
	@Column(name = "date_of_publishing")
	private Date date_of_publishing;


	@OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
	private List<Books> book;

	public int getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;

	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}
	
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_of_publishing() {
		return date_of_publishing;
	}

	public void setDate_of_publishing(Date date_of_publishing) {
		this.date_of_publishing = date_of_publishing;
	}

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}
	

}
