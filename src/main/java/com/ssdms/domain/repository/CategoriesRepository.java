package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdms.domain.model.Category;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
