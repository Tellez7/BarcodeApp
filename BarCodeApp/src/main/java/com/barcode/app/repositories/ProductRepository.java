package com.barcode.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barcode.app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Product findById(long id);
	
}
