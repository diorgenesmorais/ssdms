package com.ssdms.domain.service;

import com.dms.useful.exception.EntityNotFoundException;
import com.ssdms.api.assembler.SupplierProductInputDisassembler;
import com.ssdms.api.model.input.SupplierProductInput;
import com.ssdms.domain.model.Products;
import com.ssdms.domain.model.ProviderProducts;
import com.ssdms.domain.model.Providers;
import com.ssdms.domain.model.SupplierKeyId;
import com.ssdms.domain.repository.ProvidersRepository;
import com.ssdms.domain.repository.SupplierProductsRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    private final ProvidersRepository providersRepository;
    private final ProductService productService;
    private final SupplierProductInputDisassembler supplierProductInputDisassembler;
    private final SupplierProductsRepository supplierProductsRepository;

    public ProviderService(ProvidersRepository providersRepository, ProductService productService,
                           SupplierProductInputDisassembler supplierProductInputDisassembler,
                           SupplierProductsRepository supplierProductsRepository) {
        this.providersRepository = providersRepository;
        this.productService = productService;
        this.supplierProductInputDisassembler = supplierProductInputDisassembler;
        this.supplierProductsRepository = supplierProductsRepository;
    }

    @PersistenceContext
    private EntityManager manager;

    public List<Providers> fetchAll() {
        return providersRepository.findAll();
    }

    @Transactional
    public Providers findById(@NonNull Integer id) {
        Providers provider = providersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Não existe um fornecedor com o id %s", id)));
        provider.getProducts().size();
        return provider;
    }

    private Optional<Providers> fetchByProvider(@NonNull Integer id) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Providers> query = builder.createQuery(Providers.class);

        Root<Providers> root = query.from(Providers.class);
        root.fetch("products", JoinType.LEFT);

        Predicate predicate = builder.equal(root.get("id"), id);

        query.where(predicate);

        try {
            Providers providers = manager.createQuery(query).getSingleResult();

            return Optional.of(providers);
        } catch (NoResultException e) {
            throw new EntityNotFoundException(String.format("Não tem um fornecedor com o número %s", id));
        }
    }


    public Providers fetchById(@NonNull Integer id) {
        return fetchByProvider(id).orElseThrow(() -> new EntityNotFoundException(String.format("O %s id não retornou um fornecedor", id)));
    }

    @SuppressWarnings("null")
    @Transactional
    public ProviderProducts saveSupplierProduct(SupplierProductInput supplierProductInput) {
        ProviderProducts supplierProduct = supplierProductInputDisassembler.toDomainObject(supplierProductInput);
        return supplierProductsRepository.save(supplierProduct);
    }

    public Optional<ProviderProducts> fetchByProviderProduct(@NonNull Integer providerId, @NonNull Integer productId) {
        return supplierProductsRepository.findByProviderIdAndProductId(providerId, productId);
    }

    @Transactional
    public void deleteSupplierProduct(@NonNull ProviderProducts providerProducts) {
        supplierProductsRepository.delete(providerProducts);
    }

    @Transactional
    public void associateProducts(@NonNull Integer providerId, @NonNull Integer productId, SupplierProductInput supplierProduct) {
        Providers provider = this.fetchById(providerId);
        Products product = productService.fetchById(productId);

        SupplierKeyId providerProductId = new SupplierKeyId();
        providerProductId.setProviderId(provider.getId());
        providerProductId.setProductId(product.getId());
        supplierProduct.setProviderProductId(providerProductId);

        saveSupplierProduct(supplierProduct);
    }

    @Transactional
    public void disassociateProducts(@NonNull Integer providerId, @NonNull Integer productId) {
        ProviderProducts providerProducts = new ProviderProducts(providerId, productId);

        deleteSupplierProduct(providerProducts);
    }
}
