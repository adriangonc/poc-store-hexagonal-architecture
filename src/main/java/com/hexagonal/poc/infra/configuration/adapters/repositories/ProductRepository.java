package com.hexagonal.poc.infra.configuration.adapters.repositories;

import com.hexagonal.poc.domain.Product;
import com.hexagonal.poc.domain.ports.repositories.ProductRepositoryPort;
import com.hexagonal.poc.infra.configuration.adapters.entities.ProductEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
        Optional<ProductEntity> productEntity = this.springProductRepository.findBySku(sku);

        if (productEntity.isPresent()){
            return productEntity.get().toProduct();
        }

        throw new RuntimeException("Product not find");
    }

    @Override
    public void save(Product product) {
        ProductEntity productEntity;
        if (Objects.isNull(product.getCode())){
            productEntity = new ProductEntity(product);
        } else {
            productEntity = this.springProductRepository.findById(product.getCode()).get();
            productEntity.update(product);
        }

        this.springProductRepository.save(productEntity);
    }

    @Override
    @Transactional
    public void deleteProduct(String sku) {
        this.springProductRepository.deleteProduct(sku);
    }
}
