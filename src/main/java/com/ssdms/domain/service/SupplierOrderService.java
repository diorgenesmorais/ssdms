package com.ssdms.domain.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.dms.useful.exception.EntityNotFoundException;
import com.ssdms.api.assembler.SupplierOrderInputDisassembler;
import com.ssdms.api.model.input.SupplierOrderInput;
import com.ssdms.domain.model.Providers;
import com.ssdms.domain.model.SupplierOrder;
import com.ssdms.domain.model.dto.SupplierOrderDTO;
import com.ssdms.domain.model.dto.SupplierOrderDTOAssembler;
import com.ssdms.domain.repository.SupplierOrderRepository;
import com.ssdms.domain.repository.filter.SupplierOrderFilter;
import com.ssdms.infrastructure.repository.spec.SupplierOrderSpec;

@Service
public class SupplierOrderService {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private SupplierOrderRepository supplierOrderRepository;
	
	@Autowired
	private SupplierOrderInputDisassembler supplierOrderInputDisassembler;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private SupplierOrderDTOAssembler modelAssembler;

	public List<SupplierOrderDTO> getAll(SupplierOrderFilter supplierOrderFilter) {
		List<SupplierOrder> orders = supplierOrderRepository
				.findAll(SupplierOrderSpec.usingFilter(supplierOrderFilter));

		return modelAssembler.toCollectionModel(orders);
	}

	public Optional<SupplierOrderDTO> fetchById(@NonNull Integer id) throws EntityNotFoundException {
//		Optional<SupplierOrder> order = supplierOrderRepository.findOne(SupplierOrderSpec.searchById(id));
//		return Optional.of(modelAssembler.toModel(order.get()));

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<SupplierOrderDTO> query = builder.createQuery(SupplierOrderDTO.class);

		Root<SupplierOrder> root = query.from(SupplierOrder.class);
		// instancia o DTO pelo seu construtor
		CompoundSelection<SupplierOrderDTO> selection = builder.construct(
															SupplierOrderDTO.class, 
															root.get("id"), 
															root.get("dateOrdered"), 
															root.get("provider").get("id"));

		Predicate predicate = builder.equal(root.get("id"), id);

		query.select(selection)
				.where(predicate);

		try {
			SupplierOrderDTO dto = manager.createQuery(query).getSingleResult();
			
			return Optional.of(dto);			
		} catch (NoResultException e) {
			throw new EntityNotFoundException(String.format("Não tem um pedido com o número %s", id));
		}
	}
	
	public Optional<SupplierOrder> findById(@NonNull Integer id) {
		return supplierOrderRepository.findById(id);
	}

	@Transactional
	public SupplierOrder save(@NonNull SupplierOrder supplierOrder) {
		return supplierOrderRepository.save(supplierOrder);
	}

	@Transactional
	public SupplierOrder createOrder(@NonNull SupplierOrderInput supplierOrderInput) {
		SupplierOrder supplierOrder = supplierOrderInputDisassembler.toDomainObject(supplierOrderInput);
		Integer providerId = supplierOrderInput.getProvider().getId();
		@SuppressWarnings("null")
		Providers provider = providerService.fetchById(providerId);
		supplierOrder.setProvider(provider);

		return save(supplierOrder);
	}
}
