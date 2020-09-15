package com.dev.api.api.infrastructure;

import com.dev.api.api.donnee.dto.ProductDTO;
import com.dev.api.api.service.applicatif.ProductSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductSA productSA;

    @PostMapping("")
    public ResponseEntity<ProductDTO> handlerCreateProduct(@RequestBody ProductDTO productDTO, Errors errors) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productSA.create(productDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> handlerGetAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.getProducts());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> handlerSearchProducts(@RequestParam("query") String queryString) {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.search(queryString));
    }

    @GetMapping("/find/code")
    public ResponseEntity<ProductDTO> handlerGetByCode(@RequestParam("q") String code) {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.getByCode(code));
    }

    @GetMapping("/find/name")
    public ResponseEntity<ProductDTO> handlerGetByName(@RequestParam("q") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productSA.getByName(name));
    }
}
