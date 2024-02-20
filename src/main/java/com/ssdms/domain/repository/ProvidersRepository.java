package com.ssdms.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import com.ssdms.domain.model.Providers;

public interface ProvidersRepository extends JpaRepository<Providers, Integer> {

	@Query("from Providers p join fetch p.products pr join fetch pr.category join fetch pr.unit")
	public @NonNull Optional<Providers> findById(@NonNull Integer id);
}
