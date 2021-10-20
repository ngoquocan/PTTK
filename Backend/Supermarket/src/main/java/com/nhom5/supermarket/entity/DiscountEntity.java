package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "discount")
@Data
public class DiscountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "discountCode")
	private String discountCode;
	
	@Column(name = "discountPercent")
	private String discountPercent;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "discount")
	private List<ProductEntity> listProduct;
}
