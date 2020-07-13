package com.ma.springboot.service.impl;

import com.ma.springboot.model.Review;
import com.ma.springboot.repository.ReviewRepository;
import com.ma.springboot.service.ReviewService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
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

    @Override
    public List<String> getMostUsedWords(int limit, int offset) {
        List<String> allTexts = reviewRepository.findAllTexts();
        List<String> sortedWords = sortWords(allTexts);
        return sortedWords.stream()
                .skip(offset * limit)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private List<String> sortWords(List<String> allTexts) {
        List<String> words = allTexts
                .parallelStream()
                .flatMap(text -> Arrays.stream(text.toLowerCase()
                        .split("[^a-z]+")))
                .collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.merge(word.toLowerCase(), 1, Integer::sum);
        }
        return map.entrySet()
                .parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
