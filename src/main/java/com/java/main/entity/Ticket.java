package com.java.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	long trainId;
	
	String name;
	
	int age;
	
	float price;
	
	int discount;
	
	float finalPrice;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", trainId=" + trainId + ", name=" + name + ", age=" + age + ", price=" + price
				+ ", discount=" + discount + ", finalPrice=" + finalPrice + "]";
	}	
}
