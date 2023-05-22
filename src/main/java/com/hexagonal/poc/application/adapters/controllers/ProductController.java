package com.hexagonal.poc.application.adapters.controllers;

import com.hexagonal.poc.domain.dto.ProductDTO;
import com.hexagonal.poc.domain.ports.interfaces.ProductServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort){
        this.productServicePort = productServicePort;
    }

    @GetMapping
    List<ProductDTO> getProducts(){
        return productServicePort.findAllProducts();
    }

}
