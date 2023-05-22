package com.hexagonal.poc.infra.configuration.adapters.repositories;

import com.hexagonal.poc.domain.Product;
import com.hexagonal.poc.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepository implements ProductRepositoryPort {
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findBySku(String sku) {
        return null;
    }

    @Override
    public void save(Product product) {

    }
}
