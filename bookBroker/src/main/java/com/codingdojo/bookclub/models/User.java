package com.codingdojo.bookclub.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
		
	@PrePersist
	protected void onCreate() {
			this.createdAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
		
	@NotEmpty(message="Please enter your name")
	@Size(min=2, max=255, message="Name must be between 2 and 255 characters")
	private String name;
		
	@NotEmpty(message="Please enter a email")
	@Email(message="Email is invalid")
	private String email;
		
	@NotEmpty(message="Please enter a password")
	@Size(min=8, max=255, message="Password must be 8 to 255 characters.")
	@Column(columnDefinition="TEXT")
	private String password;
		
	@Transient
	@NotEmpty(message="Please confirm password")
	@Size(min=8, max=255, message="Confirmed password must match")
	private String confirmedPassword;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Book> books;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY)
	private List<Book> borrowedBooks;

		// Constructor
		public User() {
		}

		// Getters and Setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmedPassword() {
			return confirmedPassword;
		}

		public void setConfirmedPassword(String confirmedPassword) {
			this.confirmedPassword = confirmedPassword;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		public List<Book> getBorrowedBooks() {
			return borrowedBooks;
		}

		public void setBorrowedBooks(List<Book> borrowedBooks) {
			this.borrowedBooks = borrowedBooks;
		}
}
