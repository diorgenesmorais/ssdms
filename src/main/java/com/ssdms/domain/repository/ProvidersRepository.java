package com.ssdms.domain.repository;

import com.ssdms.domain.model.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidersRepository extends JpaRepository<Providers, Integer>, JpaSpecificationExecutor<Providers> {

}
