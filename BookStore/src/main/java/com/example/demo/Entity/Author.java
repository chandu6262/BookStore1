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
@Table(name = "author",uniqueConstraints = @UniqueConstraint(name = "author", columnNames = {"author_id"} ))
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int author_id;
	
	@Column(name = "author_name")
	private String author_name;
	
	@Column(name = "date_of_birth")
	private Date date_of_birth;


	@OneToMany(targetEntity = Books.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "author_id")
	private List<Books> books;

	public int getAuthor_id() {
		return author_id;
	}


	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}


	public String getAuthor_name() {
		return author_name;
	}


	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}

	
}
