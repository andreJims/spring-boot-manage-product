package com.dev.api.api.service.applicatif;

import com.dev.api.api.donnee.dto.ProductDTO;

import java.util.List;

public interface ProductSA {
    ProductDTO create(ProductDTO productDTO);

    List<ProductDTO> getProducts();

    List<ProductDTO> search(String queryString);

    ProductDTO getByName(String name);


    ProductDTO getByCode(String code);
}
