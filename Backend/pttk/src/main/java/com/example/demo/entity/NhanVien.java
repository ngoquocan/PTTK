package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "nhanvien")
@Data
public class NhanVien extends NguoiDung{
//	
//	@Column(name = "position")
//	private String position;
	
//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<OrderExportEntity> listOrderExport;
}
