package com.ma.springboot.service;

import com.ma.springboot.model.Review;
import java.util.List;

public interface ReviewService extends EntityService<Review> {
    List<String> getMostUsedWords(int limit, int offset);
}
