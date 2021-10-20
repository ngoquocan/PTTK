package com.nhom5.supermarket.entity;

import java.util.List;

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

@Entity(name = "supplier")
@Data
public class SupplierEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "supplierName")
	private String supplierName;	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private AddressEntity address;
	
	@OneToMany(mappedBy = "supplier")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	private List<ProductEntity> listProduct;
}
