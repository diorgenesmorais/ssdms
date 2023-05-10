package com.ssdms.api.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Categories;
import com.ssdms.domain.repository.CategoriesRepository;

@RestController
@RequestMapping("/categories")
public class CategoriesControle {

	private CategoriesRepository categoriesRepository;

	public CategoriesControle(CategoriesRepository categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	@GetMapping
	public ResponseEntity<List<Categories>> list() {
		return ResponseEntity.ok(categoriesRepository.findAll());
	}
}
