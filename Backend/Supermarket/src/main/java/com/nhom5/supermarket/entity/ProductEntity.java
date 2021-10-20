package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity(name = "product")
@Data
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "productName")
	private String productName;

	@Column(name = "importPrice")
	private Double importPrice;

	@Column(name = "price")
	private Double price;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
	private SupplierEntity supplier;

	@ManyToOne
	@JoinColumn(name = "productType_id")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
	private ProductTypeEntity productType;

	@ManyToOne
	@JoinColumn(name = "discount_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	@JsonIgnore
	private DiscountEntity discount;

	@Column(name = "description")
	private String description;
	
	@Column(name = "quantity")
	private Integer quantity;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<ImageEntity> listImage;
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<OrderDetailEntity> listOrderDetail;
	
//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<OrderExportDetailEntity> listExportOrderDetail;
	
//	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<CartDetailEntity> listCartDetail;
	
}
