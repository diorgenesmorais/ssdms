package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdms.domain.model.SupplierProducts;

public interface SupplierProductsRepository extends JpaRepository<SupplierProducts, Integer> {

}
