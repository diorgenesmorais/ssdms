package com.ssdms.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import com.ssdms.domain.model.ProviderProducts;

public interface SupplierProductsRepository extends JpaRepository<ProviderProducts, Integer> {

	@Query("from ProviderProducts p where p.supplierKeyId.providerId = :providerId and p.supplierKeyId.productId = :productId")
	public Optional<ProviderProducts> findByProviderIdAndProductId(@NonNull Integer providerId, @NonNull Integer productId);
}
