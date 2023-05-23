package com.hexagonal.poc.infra.configuration.adapters.repositories;

import com.hexagonal.poc.infra.configuration.adapters.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findBySku(String sku);

    @Modifying
    @Query("delete from ProductEntity p where p.sku =:sku ")
    void deleteProduct(@Param("sku") String sku);

}
