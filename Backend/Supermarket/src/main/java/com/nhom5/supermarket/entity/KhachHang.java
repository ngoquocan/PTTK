package com.nhom5.supermarket.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "customer")
@Data
public class KhachHang extends NguoiDung  {
	
//	@Column(name = "accountBalance")
//	private Double accountBalance;
//	
//	@OneToMany(mappedBy = "customer")
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@JsonIgnore
//	private List<OrderEntity> listOrder;
}
