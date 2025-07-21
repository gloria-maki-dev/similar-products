package com.example.similar_products.model;

import lombok.Data;

@Data
public class ProductDetailDTO {
    private String id;
    private String name;
    private Double price;
    private Boolean availability;
}
