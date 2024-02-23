package com.ssdms.infrastructure.repository.spec;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.ssdms.domain.model.Products;
import com.ssdms.domain.repository.filter.ProductFilter;

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

	private static String getLikeValue(String field) {
		return "%" + field + "%";
	}

	public static Specification<Products> usingFilter(ProductFilter productFilter) {
		return (root, query, builder) -> {
			root.fetch("category");
			root.fetch("unit");

			var predicates = new ArrayList<Predicate>();

			if (productFilter.isCodePresent()) {
				predicates.add(builder.like(root.get("code"), getLikeValue(productFilter.getCode())));
			}

			if (productFilter.isDescriptionPresent()) {
				predicates.add(builder.like(root.get("description"), getLikeValue(productFilter.getDescription())));
			}

			if (productFilter.isGTINPresent()) {
				predicates.add(builder.equal(root.get("GTIN"), productFilter.getGTIN()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
