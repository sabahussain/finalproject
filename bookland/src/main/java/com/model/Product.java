package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	 @Size(min=2, max=10, message="Your name should be between 3 - 10 characters.")
	String name;
	 @NotEmpty(message="Field can't be blank")
	String author;
	 @NotEmpty(message="Field can't be blank")
	String description;
	 @NotEmpty(message="Field can't be blank")
	String price;
	 @NotEmpty(message="Field can't be blank")
	String category;
	
	public Product()
	{
		
	}

	public Product(String name, String author, String description, String price, String category) {
		super();
		this.name = name;
		this.author = author;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", category=" + category + "]";
	}
   
}
