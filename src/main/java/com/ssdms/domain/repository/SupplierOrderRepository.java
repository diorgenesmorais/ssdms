package com.ssdms.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.SupplierOrder;

@Repository
public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Integer>, JpaSpecificationExecutor<SupplierOrder> {

	@Query("from SupplierOrder s join fetch s.provider join fetch s.provider.products p join fetch p.category join fetch p.unit")
	@NonNull
	Optional<SupplierOrder> findById(@NonNull Integer id);

}
