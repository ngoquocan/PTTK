package com.example.demo.entity;

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

@Entity(name = "sanpham")
@Data
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "ten")
	private String ten;

	@Column(name = "gianhap")
	private Double gianhap;

	@Column(name = "giaban")
	private Double giaban;

	@ManyToOne
	@JoinColumn(name = "nhacungcap_id")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
	private NhaCungCap nhacungcap;

	@ManyToOne
	@JoinColumn(name = "loai_id")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
	private LoaiSanPham loai;

	@ManyToOne
	@JoinColumn(name = "giagiam_id",referencedColumnName = "id")
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	@JsonIgnore
	private GiaGiam giagiam;

	@Column(name = "mota")
	private String mota;
	
	@Column(name = "soluong")
	private Integer soluong;

//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	@EqualsAndHashCode.Exclude
//	@ToString.Exclude
//	private List<ImageEntity> listImage;
	
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
