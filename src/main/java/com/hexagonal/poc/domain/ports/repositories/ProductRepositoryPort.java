package com.hexagonal.poc.domain.ports.repositories;

import com.hexagonal.poc.domain.Product;

import java.util.List;

public interface ProductRepositoryPort {

    List<Product> findAll();

    Product findBySku(String sku);

    void save(Product product);

    void deleteProduct(String sku);

}
