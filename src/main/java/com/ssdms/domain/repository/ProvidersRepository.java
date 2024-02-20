package com.ssdms.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import com.ssdms.domain.model.Providers;

public interface ProvidersRepository extends JpaRepository<Providers, Integer> {

	public @NonNull Optional<Providers> findById(@NonNull Integer id);
}
