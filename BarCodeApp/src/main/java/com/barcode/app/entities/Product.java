package com.barcode.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduct;

	@Column(nullable = false)
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "product")
	private List<BarCode> barcodes;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idProvider")
	private Provider provider;

	public Product() {
	}

	public Product(long idProduct, String name, Provider provider) {
		this.idProduct = idProduct;
		this.name = name;
		this.provider = provider;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BarCode> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<BarCode> barcodes) {
		this.barcodes = barcodes;
	}

	public BarCode addBarcode(BarCode barcode) {
		getBarcodes().add(barcode);
		barcode.setProduct(this);

		return barcode;
	}

	public BarCode removeBarcode(BarCode barcode) {
		getBarcodes().remove(barcode);
		barcode.setProduct(null);

		return barcode;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

}
