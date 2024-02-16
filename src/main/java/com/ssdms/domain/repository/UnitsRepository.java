package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdms.domain.model.Unit;

public interface UnitsRepository extends JpaRepository<Unit, Integer> {

}
