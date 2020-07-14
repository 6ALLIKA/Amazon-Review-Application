package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.Product;
import com.ma.springboot.model.dto.CsvReviewDto;
import com.ma.springboot.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product getProductFromParsedLineDto(CsvReviewDto csvReviewDto) {
        Product product = new Product();
        product.setId(csvReviewDto.getProductId());
        return product;
    }

    public ProductResponseDto convertToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        return productResponseDto;
    }
}
