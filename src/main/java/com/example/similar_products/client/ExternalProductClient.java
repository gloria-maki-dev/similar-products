package com.example.similar_products.client;

import com.example.similar_products.exception.ProductNotFoundException;
import com.example.similar_products.model.ProductDetailDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ExternalProductClient {

    private final RestTemplate restTemplate;

    public ExternalProductClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getSimilarProductIds(String productId) {
        try {
            String[] ids = restTemplate.getForObject(
                    "http://localhost:3001/product/{id}/similarids",
                    String[].class,
                    productId
            );
            return Arrays.asList(ids);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                throw new ProductNotFoundException(productId);
            }
            throw e;
        }
    }


    public ProductDetailDTO getProductDetail(String id) {
        try {
            return restTemplate.getForObject(
                    "http://localhost:3001/product/{id}",
                    ProductDetailDTO.class,
                    id
            );
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().value() == 404) {
                throw new ProductNotFoundException(id);
            }
            throw e;
        }
    }
}
