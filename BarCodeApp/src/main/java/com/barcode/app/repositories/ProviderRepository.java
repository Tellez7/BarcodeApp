package com.barcode.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barcode.app.entities.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

	public Provider findById(long id);

}
