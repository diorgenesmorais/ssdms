package com.ssdms.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ssdms.domain.model.Products;
import com.ssdms.domain.repository.ProductsRepository;

@Service
public class ProductService {

	private ProductsRepository repository;

	public ProductService(ProductsRepository repository) {
		this.repository = repository;
	}
	
	public List<Products> getAll() {
		return repository.findAll();
	}

	@Transactional
	public Products save(Products entity) {
		return repository.save(entity);
	}

	public List<Products> filterByDescription(String descricao) {
		return repository.findByDescricaoContaining(descricao);
	}
}
