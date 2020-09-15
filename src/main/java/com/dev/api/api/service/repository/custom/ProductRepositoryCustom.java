package com.dev.api.api.service.repository.custom;

import com.dev.api.api.donnee.domain.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findProductForQuery(String query);
}
