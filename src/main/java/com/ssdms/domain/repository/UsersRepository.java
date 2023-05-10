package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdms.domain.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
