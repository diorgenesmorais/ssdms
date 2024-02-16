package com.ssdms.infrastructure.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import com.ssdms.domain.model.Products;

public class ProductsSpec {

	public static Specification<Products> fetchByDescription(String descricao) {
		return (root, query, builder) -> {
			root.fetch("category");
			root.fetch("unit");
			
			return builder.like(root.get("description"), "%" + descricao + "%");
		};
	}

	public static Specification<Products> fetchByCode(String codigo) {
		return (root, query, builder) -> {
			root.fetch("category");
			root.fetch("unit");
			
			return builder.like(root.get("code"), codigo);
		};
	}
}
