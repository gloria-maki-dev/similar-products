package com.example.similar_products.controller;

import com.example.similar_products.model.ProductDetailDTO;
import com.example.similar_products.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService service;

    @Test
    void shouldReturn200AndJson() throws Exception {
        ProductDetailDTO dto = new ProductDetailDTO();
        dto.setId("2");
        dto.setName("Camiseta");
        dto.setPrice(9.99);
        dto.setAvailability(true);

        when(service.getSimilarProducts("1")).thenReturn(List.of(dto));

        mockMvc.perform(get("/product/1/similar"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value("2"))
                .andExpect(jsonPath("$[0].name").value("Camiseta"))
                .andExpect(jsonPath("$[0].price").value(9.99))
                .andExpect(jsonPath("$[0].availability").value(true));
    }
}
