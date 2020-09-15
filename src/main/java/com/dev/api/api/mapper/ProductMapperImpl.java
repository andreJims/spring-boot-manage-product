package com.dev.api.api.mapper;

import com.dev.api.api.donnee.domain.Product;
import com.dev.api.api.donnee.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductDTO productToProductDTO(Product product) {
        if (Objects.nonNull(product)) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setCode(product.getCode());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setValidateDate(product.getValidateDate());
            return productDTO;
        }
        return null;
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO) {
        if (Objects.nonNull(productDTO)) {
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setCode(productDTO.getCode());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setValidateDate(productDTO.getValidateDate());
            return product;
        }
        return null;
    }

    @Override
    public List<ProductDTO> productsToProductDTOS(List<Product> products) {
        return products
                .stream()
                .map(this::productToProductDTO)
                .collect(Collectors.toList());
    }
}
