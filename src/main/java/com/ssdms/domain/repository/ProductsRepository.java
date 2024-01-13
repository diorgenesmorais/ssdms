package com.ssdms.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ssdms.domain.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {

    @Query("from Products p join p.categories join p.units")
    List<Products> findAll();

    Optional<Products> findByCodigo(String codigo);
    
    List<Products> findByDescricaoContaining(String descricao);
}
