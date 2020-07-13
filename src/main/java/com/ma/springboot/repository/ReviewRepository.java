package com.ma.springboot.repository;

import com.ma.springboot.model.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r.text from Review r")
    List<String> findAllTexts();
}
