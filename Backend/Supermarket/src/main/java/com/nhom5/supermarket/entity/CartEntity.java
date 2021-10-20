package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "cart")
@Data
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	public CartEntity(CustomerEntity customer) {
		super();
		this.customer = customer;
	}

	public CartEntity() {
		super();
	}
		
	
//	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<CartDetailEntity> listCartEntity;
}
