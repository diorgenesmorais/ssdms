package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Unit;

@Repository
public interface UnitsRepository extends JpaRepository<Unit, Integer> {

}
