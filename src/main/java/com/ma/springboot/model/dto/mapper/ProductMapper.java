package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product getProductFromParsedLineDto(CsvReviewDto csvReviewDto) {
        Product product = new Product();
        product.setId(csvReviewDto.getProductId());
        return product;
    }
}
