package com.nhom5.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "order_export_detail")
public class OrderExportDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "orderexport_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private OrderExportEntity orderexport;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private ProductEntity product;
	
	@Column(name = "quantity")
	private Integer quantity;
}
