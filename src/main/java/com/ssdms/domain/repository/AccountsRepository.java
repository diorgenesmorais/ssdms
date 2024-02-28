package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

}
