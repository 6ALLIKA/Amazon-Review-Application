package com.ma.springboot.controller;

import com.ma.springboot.model.Product;
import com.ma.springboot.model.Review;
import com.ma.springboot.model.User;
import com.ma.springboot.model.dto.CsvReviewDto;
import com.ma.springboot.model.dto.mapper.ProductMapper;
import com.ma.springboot.model.dto.mapper.ReviewMapper;
import com.ma.springboot.model.dto.mapper.UserMapper;
import com.ma.springboot.service.FileParserService;
import com.ma.springboot.service.FileReaderService;
import com.ma.springboot.service.ProductService;
import com.ma.springboot.service.ReviewService;
import com.ma.springboot.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.commons.csv.CSVParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/inject")
@AllArgsConstructor
public class InjectController {
    private static final String CSV_PATH = "src/main/resources/Reviews.csv";
    private final FileParserService fileParserService;
    private final FileReaderService fileReaderService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final ReviewMapper reviewMapper;
    private final ProductMapper productMapper;

    @GetMapping
    public void injectData() {
        CSVParser csvRecords = fileReaderService.readAllLines(CSV_PATH);
        List<CsvReviewDto> csvReviewDtos = fileParserService.parseLines(csvRecords);
        Set<User> users = new HashSet<>();
        Set<Review> reviews = new HashSet<>();
        Set<Product> products = new HashSet<>();
        for (CsvReviewDto parsedLineDto : csvReviewDtos) {
            User user = userMapper.getUserFromParsedLineDto(parsedLineDto);
            users.add(user);
            Product product = productMapper.getProductFromParsedLineDto(parsedLineDto);
            products.add(product);
            Review review = reviewMapper
                    .getReviewFromParsedLineDto(parsedLineDto, user, product);
            reviews.add(review);
        }
        addEntitiesToDb(users, reviews, products);
    }

    private void addEntitiesToDb(Set<User> users, Set<Review> reviews, Set<Product> products) {
        userService.saveAll(users);
        log.info("Users have been uploaded!");
        productService.saveAll(products);
        log.info("Products have been uploaded!");
        reviewService.saveAll(reviews);
        log.info("Reviews have been uploaded!");
    }
}
