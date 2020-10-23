package com.barcode.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.app.entities.Provider;
import com.barcode.app.repositories.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
	private ProviderRepository providerRepositoriyDAO;

	public boolean add(Provider provider) {
		try {
			providerRepositoriyDAO.save(provider);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean update(Provider provider) {
		try {
			providerRepositoriyDAO.save(provider);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(long id) {
		try {
			providerRepositoriyDAO.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Provider getByID(long id) {
		return providerRepositoriyDAO.findById(id);
	}

	public List<Provider> getAll() {
		try {
			return providerRepositoriyDAO.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}