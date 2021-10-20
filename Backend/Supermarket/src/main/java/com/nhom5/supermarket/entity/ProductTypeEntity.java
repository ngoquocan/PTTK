package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "productType")
@Data
public class ProductTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "productTypeName")
	private String productTypeName;
	
	@OneToMany(mappedBy = "productType")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	private List<ProductEntity> listProduct;
}
