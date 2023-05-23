package com.hexagonal.poc.application.adapters.controllers;

import com.hexagonal.poc.domain.dto.ProductDTO;
import com.hexagonal.poc.domain.ports.interfaces.ProductServicePort;
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
    void createProduct(@RequestBody ProductDTO productDTO) {
        productServicePort.createProduct(productDTO);
    }
}
