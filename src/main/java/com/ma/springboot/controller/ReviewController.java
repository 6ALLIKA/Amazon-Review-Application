package com.ma.springboot.controller;

import com.ma.springboot.service.ReviewService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<String> getMostUsedWords(
            @RequestParam(defaultValue = "1000") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return reviewService.getMostUsedWords(limit, offset);
    }
}
