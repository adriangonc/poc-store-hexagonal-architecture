package com.hexagonal.poc.infra.configuration;

import com.hexagonal.poc.domain.adapters.services.OrderServiceImpl;
import com.hexagonal.poc.domain.ports.interfaces.ProductServicePort;
import com.hexagonal.poc.domain.ports.repositories.ProductRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ProductServicePort productServicePort(ProductRepositoryPort productRepositoryPort){
        return new OrderServiceImpl(productRepositoryPort);
    }

}
