package com.ssdms.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssdms.domain.model.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
