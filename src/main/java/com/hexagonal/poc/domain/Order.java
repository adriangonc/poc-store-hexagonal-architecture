package com.hexagonal.poc.domain;

import java.util.UUID;

public class Order {

    private UUID code;
    private String sku;
    private String name;
    private Double price;
    private Double amount;

    public Order(){

    }

    public Order(UUID code, String sku, String name, Double amount, Double price) {
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

}
