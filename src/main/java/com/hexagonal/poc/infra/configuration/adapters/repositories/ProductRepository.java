package com.hexagonal.poc.infra.configuration.adapters.repositories;

import com.hexagonal.poc.domain.Product;
import com.hexagonal.poc.domain.ports.repositories.ProductRepositoryPort;
import com.hexagonal.poc.infra.configuration.adapters.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository implements ProductRepositoryPort {

    private final SpringProductRepository springProductRepository;

    public ProductRepository(SpringProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntities = this.springProductRepository.findAll();
        return productEntities.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product findBySku(String sku) {
        return null;
    }

    @Override
    public void save(Product product) {

    }
}
