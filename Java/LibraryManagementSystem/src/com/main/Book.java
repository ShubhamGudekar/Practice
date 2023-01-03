package com.main;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String title;
	private Category cat;
	private double price;
	private LocalDate publishDate;
	private String authorName;
	private int quantity;

	public Book(String title, Category cat, double price, LocalDate publishDate, String authorName, int quantity) {
		super();
		this.title = title;
		this.cat = cat;
		this.price = price;
		this.publishDate = publishDate;
		this.authorName = authorName;
		this.quantity = quantity;
	}

	public String getAuthorName() {
		return authorName;
	}

	@Override
	public String toString() {
		return String.format("Book [Title=%-15s|Category=%-10s|Price=%-8.2f|PD=%-12s|Author=%-18s|Quantity=%d]", title,
				cat, price, publishDate, authorName, quantity);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCat() {
		return cat;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}
	
	
}
