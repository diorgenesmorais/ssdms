package com.ssdms.api.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssdms.api.model.input.SupplierOrderInput;
import com.ssdms.domain.model.SupplierOrder;
import com.ssdms.domain.model.dto.SupplierOrderDTO;
import com.ssdms.domain.repository.filter.SupplierOrderFilter;
import com.ssdms.domain.service.SupplierOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pedidos para o fornecedor")
@RestController
@RequestMapping("/supplier-order")
public class SupplierOrderController {

	@Autowired
	private SupplierOrderService supplierOrderService;

	@ApiOperation("Lista dos pedidos")
	@GetMapping
	public ResponseEntity<List<SupplierOrderDTO>> list(SupplierOrderFilter supplierOrderFilter) {
		return ResponseEntity.ok(supplierOrderService.getAll(supplierOrderFilter));
	}

	@SuppressWarnings("null")
	@ApiOperation("Consultar pedido por ID")
	@GetMapping(path = "/{id}")
	public ResponseEntity<SupplierOrderDTO> getOne(@NonNull @PathVariable Integer id) {
		return ResponseEntity.of(supplierOrderService.fetchById(id));
	}

	@ApiOperation("Criar um pedido")
	@PostMapping
	public ResponseEntity<SupplierOrder> save(@Valid @RequestBody @NonNull SupplierOrderInput supplierOrderInput) {
		return ResponseEntity.ok(supplierOrderService.createOrder(supplierOrderInput));
	}
}
