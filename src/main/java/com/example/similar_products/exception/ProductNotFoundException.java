package com.example.similar_products.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id) {
        super("Producto no encontrado con ID: " + id);
    }
}
