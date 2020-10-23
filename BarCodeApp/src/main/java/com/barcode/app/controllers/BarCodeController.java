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

import com.barcode.app.entities.BarCode;
import com.barcode.app.services.BarCodeService;

@RestController
@RequestMapping("/v1")
public class BarCodeController {

	@Autowired
	BarCodeService serviceBarCode;

	@PutMapping("/barcode")
	public boolean addBarCode(@RequestBody BarCode barCode) {
		return serviceBarCode.add(barCode);
	}

	@PostMapping("/barcode")
	public boolean updateBarCode(@RequestBody BarCode barCode) {
		return serviceBarCode.update(barCode);
	}

	@DeleteMapping("/barcode/{id}")
	public boolean deleteProduct(@PathVariable("id") long id) {
		return serviceBarCode.delete(id);
	}

	@GetMapping(value = "/barcode/{barcode}")
	public BarCode getBarcodeByBarcode(@PathVariable("barcode") String barcode) {
		return serviceBarCode.getByBarcode(barcode);
	}

	@GetMapping(value = "/barcodes")
	public List<BarCode> getBarCodes() {
		return serviceBarCode.getAll();
	}

}
