package com.nhom5.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "order_detail")
@Data
public class OrderDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "order_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private OrderEntity order;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private ProductEntity product;
	
	@Column(name = "quantity")
	private Integer quantity;

	
}
