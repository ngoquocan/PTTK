package com.nhom5.supermarket.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "hoadonnhap")
@Data
public class HoaDonNhap{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tongtien")
	private Double tongtien;
	
	@Column(name = "ngaynhap")
	private LocalDateTime ngaynhap;
	
	@ManyToOne
	@JoinColumn(name = "nhanvien_id", referencedColumnName = "id")
	private NhanVien nhanvien;
	
	@ManyToOne
	@JoinColumn(name = "nhacungcap_id")
	private NhaCungCap nhacungcap;
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<HoaDonChiTiet> listOrderDetail;
	
}
