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

import com.barcode.app.entities.Provider;
import com.barcode.app.services.ProviderService;

@RestController
@RequestMapping("/v1")
public class ProviderController {

	@Autowired
	ProviderService serviceProvider;

	@PutMapping("/provider")
	public boolean addClient(@RequestBody Provider provider) {
		return serviceProvider.add(provider);
	}

	@PostMapping("/provider")
	public boolean updateProducto(@RequestBody Provider provider) {
		return serviceProvider.update(provider);
	}

	@DeleteMapping("/provider/{id}")
	public boolean deleteProduct(@PathVariable("id") long id) {
		return serviceProvider.delete(id);
	}

	@GetMapping(value = "/provider/{id}")
	public Provider getProviderByID(@PathVariable("id") long id) {
		return serviceProvider.getByID(id);
	}

	@GetMapping(value = "/providers")
	public List<Provider> getProducts() {
		return serviceProvider.getAll();
	}

}
