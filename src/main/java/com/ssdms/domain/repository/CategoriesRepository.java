package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Category;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
