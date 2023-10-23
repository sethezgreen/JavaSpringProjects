package com.codingdojo.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
	
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Must not be blank")
	@Size(min = 5, max = 200, message = "Must be between 5 and 200 characters")
	private String burgerName;
	
	@NotNull(message = "Must not be blank")
	@Size(min = 5, max = 200, message = "Must be between 5 and 200 characters")
	private String restaurantName;
	
	@NotNull(message = "Must be between 1 and 5")
	@Min(value = 1, message = "Must be between 1 and 5")
	@Max(value = 5, message = "Must be between 1 and 5")
	private Integer rating;
	
	@NotNull(message="Must not be blank")
	@Size(min = 5, max = 200, message = "Must be between 5 and 200 characters")
	private String Notes;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

	// Constructors
	public Burger() {
	}

	public Burger(@NotNull @Size(min = 5, max = 200) String burgerName,
			@NotNull @Size(min = 5, max = 200) String restaurantName, @NotNull @Min(0) @Max(5) Integer rating) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
	}

	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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
	
	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}

	// Created at and Updated at
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
