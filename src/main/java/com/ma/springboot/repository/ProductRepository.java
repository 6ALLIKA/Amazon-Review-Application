package com.ma.springboot.repository;

import com.ma.springboot.model.Product;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select new Product(p.id) from Product p order by size(p.reviews) desc")
    List<Product> findAll(PageRequest pageRequest);
}
