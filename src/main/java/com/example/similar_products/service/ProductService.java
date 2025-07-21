package com.example.similar_products.service;

import com.example.similar_products.model.ProductDetailDTO;
import java.util.List;

public interface ProductService {
    List<ProductDetailDTO> getSimilarProducts(String productId);
}
