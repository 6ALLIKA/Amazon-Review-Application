package com.ma.springboot.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @NonNull
    private String id;
    private String profileName;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Review> reviews;

    public User(String profileName) {
        this.profileName = profileName;
    }
}
