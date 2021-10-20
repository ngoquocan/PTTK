package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "`order`")
@Data
public class OrderEntity extends BaseOrderEntity{
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private CustomerEntity customer;
	
	@ManyToOne
	@JoinColumn(name = "orderStatus_id", referencedColumnName = "id")
	private OrderStatusEntity orderStatus;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<OrderDetailEntity> listOrderDetail;
		
}
