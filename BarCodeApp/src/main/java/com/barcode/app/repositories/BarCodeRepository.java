package com.barcode.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barcode.app.entities.BarCode;

@Repository
public interface BarCodeRepository extends JpaRepository<BarCode, Long> {

	public BarCode findByBarcode(String barcode);
}
