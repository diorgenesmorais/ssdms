package com.ssdms.infrastructure.repository.spec;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.ssdms.domain.model.SupplierOrder;
import com.ssdms.domain.repository.filter.SupplierOrderFilter;

public class SupplierOrderSpec {

	public static Specification<SupplierOrder> usingFilter(SupplierOrderFilter filter) {
		return (root, query, builder) -> {

			var predicates = new ArrayList<Predicate>();

			if (filter.isStartDate()) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("dateOrdered"), filter.getStartDate()));
			}

			if (filter.isEndDate()) {
				predicates.add(builder.lessThanOrEqualTo(root.get("dateOrdered"), filter.getEndDate()));
			}

			if (filter.isProviderId()) {
				predicates.add(builder.equal(root.get("provider"), filter.getProviderId()));
			}

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
	
	public static Specification<SupplierOrder> searchById(Integer id) {
		return (root, query, builder) -> {

			return builder.equal(root.get("id"), id);
		};
	}
}
