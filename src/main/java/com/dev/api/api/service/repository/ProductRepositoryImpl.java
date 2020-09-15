package com.dev.api.api.service.repository;

import com.dev.api.api.donnee.domain.Product;
import com.dev.api.api.service.repository.custom.ProductRepositoryCustom;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductForQuery(String queryString) {
        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append(" SELECT product FROM Product product");
        if (!StringUtils.isEmpty(queryString)) {
            queryStringBuilder.append(" WHERE  lower(product.code) LIKE ('%" + queryString.toLowerCase() + "%')");
            queryStringBuilder.append(" OR  lower(product.name) LIKE ('%" + queryString.toLowerCase() + "%')");
        }
        Query query = entityManager.createQuery(queryStringBuilder.toString());
        return query.getResultList();
    }
}
