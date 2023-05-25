package com.hexagonal.poc.application.adapters.controllers;

import com.hexagonal.poc.domain.Product;
import com.hexagonal.poc.domain.dto.ProductDTO;
import com.hexagonal.poc.domain.dto.StockDTO;
import com.hexagonal.poc.domain.ports.interfaces.ProductServicePort;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @GetMapping
    List<ProductDTO> getProducts() {
        return productServicePort.findAllProducts();

    }

    @PostMapping
    Product createProduct(@RequestBody ProductDTO productDTO) {
        return productServicePort.createProduct(productDTO);
    }

    @PutMapping(value = "/{sku}")
    void updateStock(@PathVariable String sku, @RequestBody StockDTO stockDTO) throws ChangeSetPersister.NotFoundException {
        productServicePort.updateStock(sku, stockDTO);
    }

    @DeleteMapping(value = "/{sku}")
    void deleteBySku(@PathVariable String sku){
        productServicePort.deleteProductBySku(sku);
    }

}
