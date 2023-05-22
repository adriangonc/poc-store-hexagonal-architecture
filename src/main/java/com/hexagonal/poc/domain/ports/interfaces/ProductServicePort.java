package com.hexagonal.poc.domain.ports.interfaces;

import com.hexagonal.poc.domain.dto.ProductDTO;
import com.hexagonal.poc.domain.dto.StockDTO;

import java.util.List;

public interface ProductServicePort {

    List<ProductDTO> findAllProducts();

    void createProduct(ProductDTO productDTO);

    void updateStock(String sku, StockDTO stockDTO);

}
