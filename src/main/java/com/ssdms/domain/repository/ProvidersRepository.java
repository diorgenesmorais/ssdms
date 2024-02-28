package com.ssdms.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Providers;

@Repository
public interface ProvidersRepository extends JpaRepository<Providers, Integer>, JpaSpecificationExecutor<Providers> {

	@Query("from Providers p join fetch p.products pr join fetch pr.category join fetch pr.unit")
	public @NonNull Optional<Providers> findById(@NonNull Integer id);
}
