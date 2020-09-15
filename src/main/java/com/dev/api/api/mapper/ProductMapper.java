package com.dev.api.api.mapper;

import com.dev.api.api.donnee.domain.Product;
import com.dev.api.api.donnee.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOS(List<Product> products);
}
