package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdms.domain.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

}
