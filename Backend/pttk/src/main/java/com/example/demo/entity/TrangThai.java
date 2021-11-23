package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name = "trangthai")
public class TrangThai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ten")
	private String ten ;

	public TrangThai(Long id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}

	public TrangThai() {
		super();
	}
	
	
//	@OneToMany(mappedBy = "orderStatus")
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	@JsonIgnore
//	private List<OrderEntity> listOrder;
}
