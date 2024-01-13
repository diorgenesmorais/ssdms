package com.ssdms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssdms.domain.model.SupplierProducts;

public interface SupplierProductsRepository extends JpaRepository<SupplierProducts, Integer> {

	@Query("from SupplierProducts s join s.provider join s.product p join p.categories join p.units")
	@Override
	public List<SupplierProducts> findAll();
}
