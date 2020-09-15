package com.dev.api.api.service.metier;

import com.dev.api.api.donnee.domain.Product;
import com.dev.api.api.service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSMImpl implements ProductSM {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByCode(String code) {
        return productRepository.findFirstByCodeIgnoreCase(code);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findFirstByNameIgnoreCase(name);
    }

    @Override
    public List<Product> findProductForQuery(String query) {
        return productRepository.findProductForQuery(query);
    }
}
