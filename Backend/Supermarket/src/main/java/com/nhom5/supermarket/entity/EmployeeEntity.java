package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "employee")
@Data
public class EmployeeEntity extends UserEntity{
	
	@Column(name = "position")
	private String position;
	
//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<OrderExportEntity> listOrderExport;
}
