package com.ssdms.domain.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.dms.useful.exception.EntityNotFoundException;
import com.ssdms.domain.model.Products;
import com.ssdms.domain.repository.ProductsRepository;
import com.ssdms.infrastructure.repository.spec.ProductsSpec;

@Service
public class ProductService {

	private ProductsRepository repository;
	
	@PersistenceContext
	private EntityManager manager;

	public ProductService(ProductsRepository repository) {
		this.repository = repository;
	}

	public List<Products> getAll() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Products> criteria = builder.createQuery(Products.class);
		
		Root<Products> root = criteria.from(Products.class);
		
		root.fetch("category");
		root.fetch("unit");
		
		return manager.createQuery(criteria).getResultList();
	}

	@Transactional
	public Products save(@NonNull Products entity) {
		return repository.save(entity);
	}

	public List<Products> filterByDescription(String descricao) {
		return repository.findAll(ProductsSpec.fetchByDescription(descricao));
	}

	public Products fetchByCodigo(String codigo) {
		return repository.findOne(ProductsSpec.fetchByCode(codigo))
				.orElseThrow(() -> new EntityNotFoundException(String.format("Esse %s código não retornou um produto", codigo)));
	}

	public Products fetchById(@NonNull Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(String.format("O %s id não retornou um produto", id)));
	}
}
