package com.barcode.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.app.entities.Product;
import com.barcode.app.services.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {

	@Autowired
	ProductService serviceProduct;

	@PutMapping("/product")
	public boolean addproduct(@RequestBody Product product) {
		return serviceProduct.add(product);
	}

	@PostMapping("/product")
	public boolean updateProducto(@RequestBody Product product) {
		return serviceProduct.update(product);
	}

	@DeleteMapping("/product/{id}")
	public boolean deleteProduct(@PathVariable("id") long id) {
		return serviceProduct.delete(id);
	}

	@GetMapping(value = "/product/{id}")
	public Product getProductByID(@PathVariable("id") long id) {
		return serviceProduct.getByID(id);
	}

	@GetMapping(value = "/products")
	public List<Product> getProducts() {
		return serviceProduct.getAll();
	}

}
