package com.ma.springboot.service.impl;

import com.ma.springboot.model.Review;
import com.ma.springboot.repository.ReviewRepository;
import com.ma.springboot.service.ReviewService;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> saveAll(Set<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }
}
