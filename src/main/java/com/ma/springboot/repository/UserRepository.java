package com.ma.springboot.repository;

import com.ma.springboot.model.User;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select new User(u.profileName) from User u order by size(u.reviews) desc")
    List<User> findAllMostActive(PageRequest pageRequest);
}
