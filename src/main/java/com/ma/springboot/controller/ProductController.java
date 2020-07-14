package com.ma.springboot.controller;

import com.ma.springboot.model.Product;
import com.ma.springboot.model.dto.ProductResponseDto;
import com.ma.springboot.model.dto.mapper.ProductMapper;
import com.ma.springboot.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductResponseDto> getMostCommentedProducts(
            @RequestParam(defaultValue = "1000") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        List<Product> products = productService.getMostCommentedProducts(limit, offset);
        return products.stream()
                .map(productMapper::convertToProductResponseDto)
                .collect(Collectors.toList());
    }
}
