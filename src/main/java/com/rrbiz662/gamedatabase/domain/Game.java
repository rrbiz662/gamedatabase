package com.rrbiz662.gamedatabase.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Game {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long gameId; // Primary key w/ auto-generated value
	private String name, publisher, serialNumber;
	@Column(name="pubYear")
	private int year;
	private BigDecimal price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Game() {
		// Required for Spring Boot to work
	}	
	
	public Game(String name, String publisher, String serialNumber, int year, BigDecimal price, Owner owner) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.serialNumber = serialNumber;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}	
	
	public long getId() {
		return gameId;
	}
	
	public void setId(long gameId) {
		this.gameId = gameId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}	
	
}