package com.dev.api.api.service.applicatif;

import com.dev.api.api.donnee.dto.ProductDTO;
import com.dev.api.api.exceptions.FunctionalInvalidDataException;
import com.dev.api.api.mapper.ProductMapper;
import com.dev.api.api.service.metier.ProductSM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class ProductSAImpl implements ProductSA {

    @Autowired
    private ProductSM productSM;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        this.verifyData(productDTO);
        return productMapper.productToProductDTO(productSM.save(
                productMapper.productDTOToProduct(productDTO)
        ));
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productMapper.productsToProductDTOS(productSM.findAll());
    }

    @Override
    public List<ProductDTO> search(String queryString) {
        return productMapper.productsToProductDTOS(productSM.findProductForQuery(queryString));
    }

    @Override
    public ProductDTO getByName(String name) {
        return productMapper.productToProductDTO(productSM.findByName(name));
    }

    @Override
    public ProductDTO getByCode(String code) {
        return productMapper.productToProductDTO(productSM.findByCode(code));
    }

    private void verifyData(ProductDTO productDTO) {
        if (StringUtils.isEmpty(productDTO.getName())
                || StringUtils.isEmpty(productDTO.getCode())
                || Objects.isNull(productDTO.getValidateDate())
                || Objects.isNull(productDTO.getPrice())) {
            throw new FunctionalInvalidDataException("DATA_HAS_ERROR");
        } else if (Objects.nonNull(this.getByName(productDTO.getName()))) {
            throw new FunctionalInvalidDataException("NAME_ALREADY_EXIST");
        } else if (Objects.nonNull(this.getByCode(productDTO.getCode()))) {
            throw new FunctionalInvalidDataException("CODE_ALREADY_EXIST");
        }
    }
}
