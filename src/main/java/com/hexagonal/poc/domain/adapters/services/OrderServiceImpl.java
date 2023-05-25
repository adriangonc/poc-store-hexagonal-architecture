package com.hexagonal.poc.domain.adapters.services;

import com.hexagonal.poc.domain.Product;
import com.hexagonal.poc.domain.dto.ProductDTO;
import com.hexagonal.poc.domain.dto.StockDTO;
import com.hexagonal.poc.domain.ports.interfaces.ProductServicePort;
import com.hexagonal.poc.domain.ports.repositories.ProductRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public OrderServiceImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> products = this.productRepositoryPort.findAll();
        List<ProductDTO> productsDTO = products.stream().map(Product::toProductDto).collect(Collectors.toList());
        return productsDTO;
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        try {
            this.productRepositoryPort.save(product);
            return product;
        } catch (Exception e){
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void updateStock(String sku, StockDTO stockDTO) {

    }

    @Override
    public void deleteProductBySku(String sku) {
        this.productRepositoryPort.deleteProduct(sku);
    }
}
