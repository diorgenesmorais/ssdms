package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
