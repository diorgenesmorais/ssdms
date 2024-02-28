package com.ssdms.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ssdms.domain.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {

    @Query("from Products p join p.category join p.unit")
	@NonNull
    List<Products> findAll();

    Optional<Products> findByCode(String codigo);
    
    List<Products> findByDescriptionContaining(String descricao);
    
}
