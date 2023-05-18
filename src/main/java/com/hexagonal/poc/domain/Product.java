package com.hexagonal.poc.domain;

import com.hexagonal.poc.domain.dto.ProductDTO;

import java.util.UUID;

public class Product {

    private UUID code;
    private String sku;
    private String name;
    private Double price;
    private Double amount;

    public Product(){

    }

    public Product(UUID code, String sku, String name, Double amount, Double price) {
        this.code = code;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public UUID getCode() {
        return code;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAmount() {
        return amount;
    }


    public Product(ProductDTO productDTO) {
        this.sku = productDTO.getSku();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.amount = productDTO.getAmount();
    }

    public void updateStock(double amount) {
        this.amount = amount;
    }

    public ProductDTO toProductDto() {
        return new ProductDTO(this.sku, this.name, this.price, this.amount);
    }

}
