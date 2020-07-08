package com.ma.springboot.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private String id;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;
}