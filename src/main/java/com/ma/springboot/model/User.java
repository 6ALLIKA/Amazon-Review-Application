package com.ma.springboot.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    private String id;
    private String profileName;
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;
}
