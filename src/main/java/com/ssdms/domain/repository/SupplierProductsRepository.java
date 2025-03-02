package com.ssdms.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.ProviderProducts;
import com.ssdms.domain.model.SupplierKeyId;

@Repository
public interface SupplierProductsRepository extends JpaRepository<ProviderProducts, SupplierKeyId> {

	@Query("from ProviderProducts p where p.supplierKeyId.providerId = :providerId and p.supplierKeyId.productId = :productId")
	public Optional<ProviderProducts> findByProviderIdAndProductId(@NonNull Integer providerId, @NonNull Integer productId);
}
