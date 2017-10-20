package com.liveasy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "house")
public class House {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="house_id")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "address")
	private String address;

	@Column(name = "bedrooms")
	private int bedrooms;
	
	@Column(name = "washrooms")
	private int washrooms;
	
	@Column(name = "area")
	private int area;
	
	@Column(name = "yearBuilt")
	private int yearBuilt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		
		if(!user.getHouses().contains(this)) {
			user.addHouse(this);
		}
		
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getWashrooms() {
		return washrooms;
	}

	public void setWashrooms(int washrooms) {
		this.washrooms = washrooms;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	
 

}
