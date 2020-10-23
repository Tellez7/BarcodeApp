package com.barcode.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.app.entities.Product;
import com.barcode.app.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepositoriyDAO;

	public boolean add(Product product) {
		try {
			productRepositoriyDAO.save(product);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			productRepositoriyDAO.save(product);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(long id) {
		try {
			productRepositoriyDAO.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Product getByID(long id) {
		return productRepositoriyDAO.findById(id);
	}

	public List<Product> getAll() {
		try {
			return productRepositoriyDAO.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
