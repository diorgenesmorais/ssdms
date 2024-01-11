package com.ssdms.api.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.domain.model.Categories;
import com.ssdms.domain.repository.CategoriesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Categorias")
@RestController
@RequestMapping("/categories")
public class CategoriesController {

	private CategoriesRepository categoriesRepository;

	public CategoriesController(CategoriesRepository categoriesRepository) {
		this.categoriesRepository = categoriesRepository;
	}

	@ApiOperation("Lista de categorias")
	@GetMapping
	public ResponseEntity<List<Categories>> list() {
		return ResponseEntity.ok(categoriesRepository.findAll());
	}
}
