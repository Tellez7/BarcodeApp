package com.barcode.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Barcode")
public class BarCode implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBarcode;

	@Column(nullable = false)
	private String name;
	
	private String barcode;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	public BarCode() {
	}

	public BarCode(long idBarcode, String name, String barcode, Product product) {
		this.idBarcode = idBarcode;
		this.name = name;
		this.barcode = barcode;
		this.product = product;
	}

	public long getIdBarcode() {
		return idBarcode;
	}

	public void setIdBarcode(long idBarcode) {
		this.idBarcode = idBarcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
