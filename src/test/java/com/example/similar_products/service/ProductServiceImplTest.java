package com.example.similar_products.service;

import com.example.similar_products.client.ExternalProductClient;
import com.example.similar_products.model.ProductDetailDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    ExternalProductClient client;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    void returnsFilledDtoList_whenApisSucceed() {
        when(client.getSimilarProductIds("1")).thenReturn(List.of("2", "3"));

        ProductDetailDTO dto2 = new ProductDetailDTO();
        dto2.setId("2");
        ProductDetailDTO dto3 = new ProductDetailDTO();
        dto3.setId("3");

        when(client.getProductDetail("2")).thenReturn(dto2);
        when(client.getProductDetail("3")).thenReturn(dto3);

        List<ProductDetailDTO> result = service.getSimilarProducts("1");

        assertThat(result)
                .extracting(ProductDetailDTO::getId)
                .containsExactly("2", "3");
    }
}
