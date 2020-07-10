package com.ma.springboot.service.impl;

import com.ma.springboot.model.Product;
import com.ma.springboot.repository.ProductRepository;
import com.ma.springboot.service.ProductService;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAll(Set<Product> products) {
        return productRepository.saveAll(products);
    }
}
