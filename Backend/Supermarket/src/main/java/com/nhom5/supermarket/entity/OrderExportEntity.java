package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "order_export")
@Data
public class OrderExportEntity extends BaseOrderEntity {
	@ManyToOne()
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private EmployeeEntity employee;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<OrderDetailEntity> listOrderDetail;
	
}
