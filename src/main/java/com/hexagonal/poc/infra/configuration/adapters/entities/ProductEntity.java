package com.hexagonal.poc.infra.configuration.adapters.entities;

import com.hexagonal.poc.domain.Product;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;
    private String sku;
    private String name;
    private Double price;
    private Double amount;

    public ProductEntity(){

    }

    public ProductEntity(Product product) {
        this.sku = product.getSku();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
    }

    public void update(Product product){
        this.sku = product.getSku();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
    }

    public Product toProduct(){
        return new Product(this.code, this.sku, this.name, this.amount, this.price);
    }
}
