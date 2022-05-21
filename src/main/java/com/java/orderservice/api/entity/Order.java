package com.java.orderservice.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	@Id
	private int id;
	private String name;
	private int quatity;
	private double price;

}
