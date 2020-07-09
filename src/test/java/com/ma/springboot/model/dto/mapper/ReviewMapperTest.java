package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.Product;
import com.ma.springboot.model.Review;
import com.ma.springboot.model.User;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReviewMapperTest {
    private final CsvMapper csvMapper = new CsvMapper();
    private final ReviewMapper reviewMapper = new ReviewMapper();

    @SneakyThrows
    @Test
    void create_review_TRUE() {
        Review reviewExpected = new Review();
        reviewExpected.setId(1L);
        reviewExpected.setHelpfulnessNumerator(1);
        reviewExpected.setHelpfulnessDenominator(1);
        reviewExpected.setScore(5);
        reviewExpected.setTime(Instant.ofEpochMilli(1303862400L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        reviewExpected.setSummary("Good Quality Dog Food");
        reviewExpected.setText("I have bought several of the Vitality canned dog food products and "
                + "have found them all to be of good quality. The product looks more like "
                + "a stew than a processed meat and it smells better. My Labrador is finicky"
                + " and she appreciates this product better than  most.");

        Product productExpected = new Product();
        productExpected.setId("B001E4KFG0");
        reviewExpected.setProduct(productExpected);

        User user = new User();
        user.setId("A3SGXH7AUHU8GW");
        user.setProfileName("delmartian");
        user.setReviews(Set.of(reviewExpected));
        reviewExpected.setUser(user);

        InputStream inputStream = new FileInputStream("src/test/resources/csv-sololine-test.csv");
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        CSVRecord firstLine = csvParser.getRecords().get(0);
        Review reviewActual = reviewMapper.getReviewFromParsedLineDto(csvMapper.parseLineToDto(firstLine),
                user,
                productExpected);

        assertEquals(reviewExpected, reviewActual);
    }
}