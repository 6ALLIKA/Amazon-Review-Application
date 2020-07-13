package com.ma.springboot.service;

import com.ma.springboot.model.Product;
import java.util.List;

public interface ProductService extends EntityService<Product> {
    List<Product> getMostCommentedProducts(int limit, int offset);
}
