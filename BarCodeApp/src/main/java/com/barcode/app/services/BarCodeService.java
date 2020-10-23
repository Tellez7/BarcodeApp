package com.barcode.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.app.entities.BarCode;
import com.barcode.app.repositories.BarCodeRepository;

@Service
public class BarCodeService {

	@Autowired
	private BarCodeRepository barcodeRepositoriyDAO;

	public boolean add(BarCode barCode) {
		try {
			barcodeRepositoriyDAO.save(barCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean update(BarCode barCode) {
		try {
			barcodeRepositoriyDAO.save(barCode);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean delete(long id) {
		try {
			barcodeRepositoriyDAO.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public BarCode getByBarcode(String barcode) {
		return barcodeRepositoriyDAO.findByBarcode(barcode);
	}

	public List<BarCode> getAll() {
		try {
			return barcodeRepositoriyDAO.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
