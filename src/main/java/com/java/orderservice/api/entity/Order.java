package com.java.orderservice.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TABLE")
public class Order {
	
	@Id
	private int id;
	private String name;
	private int quatity;
	private double price;

}
