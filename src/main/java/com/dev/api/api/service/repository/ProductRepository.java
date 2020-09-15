package com.dev.api.api.service.repository;

import com.dev.api.api.donnee.domain.Product;
import com.dev.api.api.service.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ProductRepositoryCustom, JpaRepository<Product, Long> {
    Product findFirstByCodeIgnoreCase(String code);

    Product findFirstByNameIgnoreCase(String name);
}
