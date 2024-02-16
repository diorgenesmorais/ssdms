package com.ssdms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import com.ssdms.domain.model.SupplierProducts;

public interface SupplierProductsRepository extends JpaRepository<SupplierProducts, Integer> {

	@Query("from SupplierProducts s join s.provider join s.product p join p.category join p.unit")
	@Override
	public @NonNull List<SupplierProducts> findAll();
}
