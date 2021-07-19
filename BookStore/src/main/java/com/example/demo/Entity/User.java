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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(name = "user", columnNames = {"user_id","contact","email"} ))
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "user_id")
		@NotNull(message = "user id is required")
		private int user_id;
		
		@Column(name = "password")
		@NotNull(message = "password is mandatory")
		@NotEmpty(message = "password should not be empty")
		@Size(min = 8,message = "password must be atleast 8 characters")
		private String password;
		
		@Column(name = "user_type")
		private String user_type;
		
		@Column(name = "first_name")
		@NotNull(message = "First name is a required field")
		@NotEmpty(message = "First name should not be empty")
		private String first_name;
		
		@Column(name = "last_name")
		@NotNull(message = "Last name is a required field")
		@NotEmpty(message = "Last name should not be empty")
		private String last_name;
		
		@Column(name = "contact")
		@NotNull(message = "contact number is required field")
		private long contact;
		
		@Column(name = "email")
		@NotNull(message = "email is required field")
		@NotEmpty(message = "email should not be empty")
		private String email;
		
		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(name = "users_books",joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "book_id")})
		private List<Books> book = new ArrayList<>();

		@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "user_id")
		private List<Address> address;

		@OneToMany(targetEntity = Orders.class, cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "user_id")
		private List<Orders> order;

		@OneToMany(targetEntity = Rent.class, cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "user_id")
		private List<Rent> rent;

		@OneToMany(targetEntity = RentedBooksDetails.class, cascade = CascadeType.ALL)
		@JoinColumn(name = "user_id", referencedColumnName = "user_id")
		private List<RentedBooksDetails> details;
		
		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUser_type() {
			return user_type;
		}

		public void setUser_type(String user_type) {
			this.user_type = user_type;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public long getContact() {
			return contact;
		}

		public void setContact(long contact) {
			this.contact = contact;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public List<Books> getBook() {
			return book;
		}

		public void setBook(List<Books> book) {
			this.book = book;
		}

		public List<Address> getAddress() {
			return address;
		}

		public void setAddress(List<Address> address) {
			this.address = address;
		}

		public List<Orders> getOrder() {
			return order;
		}

		public void setOrder(List<Orders> order) {
			this.order = order;
		}

		public List<Rent> getRent() {
			return rent;
		}

		public void setRent(List<Rent> rent) {
			this.rent = rent;
		}

		public List<RentedBooksDetails> getDetails() {
			return details;
		}

		public void setDetails(List<RentedBooksDetails> details) {
			this.details = details;
		}
		
		
	}

