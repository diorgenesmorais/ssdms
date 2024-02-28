package com.ssdms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Rates;

@Repository
public interface RatesRepository extends JpaRepository<Rates, Integer> {

    @Query("from Rates r join fetch r.account")
	@NonNull
    List<Rates> findAll();
}
