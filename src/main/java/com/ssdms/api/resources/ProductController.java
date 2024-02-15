package com.ssdms.api.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.api.model.CategoryModel;
import com.ssdms.api.model.ProductModel;
import com.ssdms.api.model.UnitModel;
import com.ssdms.domain.model.Products;
import com.ssdms.domain.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Produtos")
@RestController
@RequestMapping(value =  "/products", produces = MediaType.APPLICATION_JSON_VALUE )
public class ProductController {

	@Autowired
	private ProductService productService;

	@ApiOperation("Lista de produtos")
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAll() {
		var products = productService.getAll();

		return ResponseEntity.ok(toCollectionModel(products));
	}
	
	@SuppressWarnings("null")
	@ApiOperation("Obter um produto por seu identificador")
	@GetMapping( path = "/{id}" )
	public ResponseEntity<ProductModel> findById(@PathVariable String id) {
		Optional<Products> product = Optional.of(productService.fetchByCodigo(id));
		
		return ResponseEntity.of(toModel(product));
	}
	
	@ApiOperation("Adicionar um produto")
	@PostMapping
	public ResponseEntity<Optional<ProductModel>> save(@Valid @RequestBody @NonNull Products product) {
		Optional<Products> productSave = Optional.of(productService.save(product));

		return ResponseEntity.status(HttpStatus.CREATED).body(toModel(productSave));
	}

	@ApiOperation("Filtra produtos por descrição")
	@GetMapping(value = "/for-description")
	public ResponseEntity<List<Products>> filterByDescription(String description) {
		return ResponseEntity.ok(productService.filterByDescription(description));
	}

	private Optional<ProductModel> toModel(Optional<Products> product) {
		
		if(product.isEmpty()) {
			return Optional.empty();
		}
		Products entity = product.get();
		ProductModel productModel = new ProductModel();
		productModel.setCode(entity.getCodigo());
		productModel.setDescription(entity.getDescricao());
			CategoryModel categoriaModel = new CategoryModel();
			categoriaModel.setId(entity.getCategories().getId());
			categoriaModel.setName(entity.getCategories().getName());
		productModel.setCategoria(categoriaModel);
		productModel.setNCM(entity.getNCM());
		productModel.setCEST(entity.getCEST());
		productModel.setGTIN(entity.getGTIN());
		productModel.setPrice(entity.getPreco());
		productModel.setStock(entity.getEstoque());
			UnitModel unitModel = new UnitModel();
			unitModel.setId(entity.getUnits().getId());
			unitModel.setDescription(entity.getUnits().getDescription());
		productModel.setUnit(unitModel);
		productModel.setDetails(entity.getDetalhes());

		return Optional.ofNullable(productModel);
	}

	private List<ProductModel> toCollectionModel(List<Products> products) {
		return products.stream()
					.map(product -> toModel(Optional.of(product)).get())
					.collect(Collectors.toList());
	}
}
