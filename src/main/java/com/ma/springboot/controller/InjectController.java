package com.ma.springboot.controller;

import com.ma.springboot.model.Client;
import com.ma.springboot.model.Product;
import com.ma.springboot.model.Review;
import com.ma.springboot.model.Role;
import com.ma.springboot.model.User;
import com.ma.springboot.model.dto.CsvReviewDto;
import com.ma.springboot.model.dto.mapper.ProductMapper;
import com.ma.springboot.model.dto.mapper.ReviewMapper;
import com.ma.springboot.model.dto.mapper.UserMapper;
import com.ma.springboot.service.ClientService;
import com.ma.springboot.service.FileParserService;
import com.ma.springboot.service.FileReaderService;
import com.ma.springboot.service.ProductService;
import com.ma.springboot.service.ReviewService;
import com.ma.springboot.service.RoleService;
import com.ma.springboot.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.commons.csv.CSVRecord;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/inject")
@AllArgsConstructor
public class InjectController {
    private static final String CSV_PATH = "src/main/resources/test.csv";
    private final RoleService roleService;
    private final FileParserService fileParserService;
    private final FileReaderService fileReaderService;
    private final ProductService productService;
    private final ReviewService reviewService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final ReviewMapper reviewMapper;
    private final ProductMapper productMapper;
    private final PasswordEncoder passwordEncoder;
    private final ClientService clientService;

    @GetMapping
    public void injectData() {
        Iterable<CSVRecord> recordsFromCsv = fileReaderService.getRecordsFromCsv(CSV_PATH);
        List<CsvReviewDto> csvReviewDtos = fileParserService.parseLines(recordsFromCsv);
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
        injectRoles();
        injectUsers();
    }

    private void addEntitiesToDb(Set<User> users, Set<Review> reviews, Set<Product> products) {
        userService.saveAll(users);
        log.info("Users have been uploaded!");
        productService.saveAll(products);
        log.info("Products have been uploaded!");
        reviewService.saveAll(reviews);
        log.info("Reviews have been uploaded!");
    }

    private void injectUsers() {
        Client admin = new Client();
        admin.setLogin("admin");
        admin.setRoles(Set.of(roleService.findByRoleName(Role.RoleName.ADMIN)));
        admin.setPassword(passwordEncoder.encode("1234"));
        Client user = new Client();
        user.setLogin("user");
        user.setRoles(Set.of(roleService.findByRoleName(Role.RoleName.USER)));
        user.setPassword(passwordEncoder.encode("1234"));
        clientService.saveAll(Set.of(admin, user));
    }

    private void injectRoles() {
        Role user = new Role(Role.RoleName.USER);
        Role admin = new Role(Role.RoleName.ADMIN);
        roleService.saveAll(Set.of(user, admin));
    }
}
