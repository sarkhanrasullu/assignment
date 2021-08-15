package com.remotecella.assignment;

import com.remotecella.assignment.controller.ProductController;
import com.remotecella.assignment.service.ProductService;
import com.remotecella.assignment.service.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllerIntegrationTest {

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @Test
    public void givenProducts_whenGetProducts_thenReturnList() throws Exception {
        ProductDto product = new ProductDto().setName("product name");
        List<ProductDto> list = Arrays.asList(product);
        when(service.getProducts(null, null, "ASC", 0, 10)).thenReturn(list);

        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();;
        mvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(1)))
                .andExpect(jsonPath("$.data[0].name", is(product.getName())));
    }
}
