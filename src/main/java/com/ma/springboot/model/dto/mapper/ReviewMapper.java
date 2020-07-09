package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.Product;
import com.ma.springboot.model.Review;
import com.ma.springboot.model.User;
import com.ma.springboot.model.dto.CsvReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review getReviewFromParsedLineDto(CsvReviewDto csvReviewDto,
                                             User user, Product product) {
        Review review = new Review();
        review.setId(csvReviewDto.getId());
        review.setUser(user);
        review.setProduct(product);
        review.setScore(csvReviewDto.getScore());
        review.setHelpfulnessDenominator(csvReviewDto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(csvReviewDto.getHelpfulnessNumerator());
        review.setTime(csvReviewDto.getTime());
        review.setSummary(csvReviewDto.getSummary());
        review.setText(csvReviewDto.getText());
        return review;
    }
}