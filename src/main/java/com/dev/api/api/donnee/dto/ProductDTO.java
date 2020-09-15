package com.dev.api.api.donnee.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String code;
    private String name;
    private LocalDate validateDate;
    private Double price;
}
