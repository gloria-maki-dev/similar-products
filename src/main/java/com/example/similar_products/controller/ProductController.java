package com.example.similar_products.controller;

import com.example.similar_products.model.ProductDetailDTO;
import com.example.similar_products.service.ProductService;
import com.example.similar_products.service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @Operation(summary = "Obtener productos similares por ID de producto")
    @GetMapping("/{id}/similar")
    public ResponseEntity<List<ProductDetailDTO>> getSimilarProducts(@PathVariable String id) {
        List<ProductDetailDTO> similarProducts = service.getSimilarProducts(id);
        return ResponseEntity.ok(similarProducts);
    }
}
