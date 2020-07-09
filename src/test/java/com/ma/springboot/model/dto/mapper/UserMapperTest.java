package com.ma.springboot.model.dto.mapper;

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

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {
    private final CsvMapper csvMapper = new CsvMapper();
    private final UserMapper userMapper = new UserMapper();

    @SneakyThrows
    @Test
    void create_review_TRUE() {
        User userExpected = new User();
        userExpected.setId("A3SGXH7AUHU8GW");
        userExpected.setProfileName("delmartian");

        InputStream inputStream = new FileInputStream("src/test/resources/csv-sololine-test.csv");
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        CSVRecord firstLine = csvParser.getRecords().get(0);
        User userActual = userMapper.getUserFromParsedLineDto(csvMapper.parseLineToDto(firstLine));

        assertEquals(userExpected, userActual);
    }
}