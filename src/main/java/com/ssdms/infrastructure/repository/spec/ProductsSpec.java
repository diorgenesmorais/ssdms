package com.ssdms.infrastructure.repository.spec;

import org.springframework.data.jpa.domain.Specification;

import com.ssdms.domain.model.Products;

public class ProductsSpec {

	public static Specification<Products> fetchByDescription(String descricao) {
		return (root, query, builder) -> {
			root.fetch("categories");
			root.fetch("units");
			
			return builder.like(root.get("descricao"), "%" + descricao + "%");
		};
	}

	public static Specification<Products> fetchByCodigo(String codigo) {
		return (root, query, builder) -> {
			root.fetch("categories");
			root.fetch("units");
			
			return builder.like(root.get("codigo"), codigo);
		};
	}
}
