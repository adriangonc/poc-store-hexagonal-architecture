package com.hexagonal.poc.domain.dto;

public class ProductDTO {

    private String sku;
    private String name;
    private Double price;
    private Double amount;

    public ProductDTO(String sku, String name, Double price, Double amount) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.amount = amount;
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
}
