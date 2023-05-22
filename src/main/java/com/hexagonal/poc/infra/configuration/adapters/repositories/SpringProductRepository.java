package com.hexagonal.poc.infra.configuration.adapters.repositories;

import com.hexagonal.poc.infra.configuration.adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findBySku(String sku);

}
