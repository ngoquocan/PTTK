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

@Entity(name = "hoadon")
@Data
public class HoaDon{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tongtien")
	private Double tongtien;
	
	@Column(name = "ngaydat")
	private LocalDateTime ngaydat;
	
	@Column(name = "ngayxuat")
	private LocalDateTime ngayxuat;
	
	@ManyToOne
	@JoinColumn(name = "khachhang_id", referencedColumnName = "id")
	private KhachHang khachhang;
	
	@ManyToOne
	@JoinColumn(name = "nhanvien_id")
	private NhanVien nhanvien;
	
	@ManyToOne
	@JoinColumn(name = "trangthai_id", referencedColumnName = "id")
	private TrangThai trangthai;
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<OrderDetailEntity> listOrderDetail;
		
}
