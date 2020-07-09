package com.ma.springboot.service.impl;

import com.ma.springboot.model.dto.CsvReviewDto;
import com.ma.springboot.model.dto.mapper.CsvMapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileParserFromCsvServiceImplTest {
    private FileParserFromCsvServiceImpl fileParserFromCsvService =
            new FileParserFromCsvServiceImpl(new CsvMapper());

    @SneakyThrows
    @Test
    void parsing_TRUE() {

        CsvReviewDto dto1 = new CsvReviewDto();
        dto1.setId(1L);
        dto1.setProductId("B001E4KFG0");
        dto1.setUserId("A3SGXH7AUHU8GW");
        dto1.setProfileName("delmartian");
        dto1.setHelpfulnessNumerator(1);
        dto1.setHelpfulnessDenominator(1);
        dto1.setScore(5);
        dto1.setTime(Instant.ofEpochMilli(1303862400L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto1.setSummary("Good Quality Dog Food");
        dto1.setText("I have bought several of the Vitality canned dog food products and "
                + "have found them all to be of good quality. The product looks more like "
                + "a stew than a processed meat and it smells better. My Labrador is finicky"
                + " and she appreciates this product better than  most.");

        CsvReviewDto dto2 = new CsvReviewDto();
        dto2.setId(2L);
        dto2.setProductId("B00813GRG4");
        dto2.setUserId("A1D87F6ZCVE5NK");
        dto2.setProfileName("dll pa");
        dto2.setHelpfulnessNumerator(0);
        dto2.setHelpfulnessDenominator(0);
        dto2.setScore(1);
        dto2.setTime(Instant.ofEpochMilli(1346976000L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto2.setSummary("Not as Advertised");
        dto2.setText("Product arrived labeled as Jumbo Salted Peanuts...the peanuts were "
                + "actually small sized unsalted. Not sure if this was an error or "
                + "if the vendor intended to represent the product as \"Jumbo\".");

        CsvReviewDto dto3 = new CsvReviewDto();
        dto3.setId(3L);
        dto3.setProductId("B000LQOCH0");
        dto3.setUserId("ABXLMWJIXXAIN");
        dto3.setProfileName("Natalia Corres \"Natalia Corres\"");
        dto3.setHelpfulnessNumerator(1);
        dto3.setHelpfulnessDenominator(1);
        dto3.setScore(4);
        dto3.setTime(Instant.ofEpochMilli(1219017600L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto3.setSummary("\"Delight\" says it all");
        dto3.setText("This is a confection that has been around a few centuries. "
                + " It is a light, pillowy citrus gelatin with nuts - in this case Filberts. "
                + "And it is cut into tiny squares and then liberally coated with powdered sugar. "
                + " And it is a tiny mouthful of heaven.  Not too chewy, and very flavorful. "
                + " I highly recommend this yummy treat.  If you are familiar with the story of "
                + "C.S. Lewis' \"The Lion, The Witch, and The Wardrobe\" - this is the treat "
                + "that seduces Edmund into selling out his Brother and Sisters to the Witch.");

        List<CsvReviewDto> expected = new ArrayList<>();
        expected.add(dto1);
        expected.add(dto2);
        expected.add(dto3);

        InputStream inputStream = new FileInputStream("src/test/java/resources/csv-test.csv");
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

        assertEquals(expected, fileParserFromCsvService.parseLines(csvParser));
    }
}
