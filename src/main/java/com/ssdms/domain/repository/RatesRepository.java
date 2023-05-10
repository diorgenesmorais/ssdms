package com.ssdms.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssdms.domain.model.Rates;

public interface RatesRepository extends JpaRepository<Rates, Integer> {

    @Query("from Rates r join fetch r.account")
    List<Rates> findAll();
}
