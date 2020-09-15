package com.dev.api.api.service.metier;

import com.dev.api.api.donnee.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSM {
    Product save(Product product);

    List<Product> findAll();

    Product findByCode(String code);

    Product findByName(String name);

    List<Product> findProductForQuery(String query);
}
