package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.Product;
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

class ProductMapperTest {
    public static final String SOLOLINE_TEST_CSV = "src/test/resources/csv-sololine-test.csv";
    private final ProductMapper productMapper = new ProductMapper();
    private final CsvMapper csvMapper = new CsvMapper();

    @SneakyThrows
    @Test
    void create_product_TRUE() {
        Product productExpected = new Product();
        productExpected.setId("B001E4KFG0");
        InputStream inputStream = new FileInputStream(SOLOLINE_TEST_CSV);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        CSVRecord firstLine = csvParser.getRecords().get(0);
        Product productActual = productMapper.getProductFromParsedLineDto(csvMapper.parseLineToDto(firstLine));
        assertEquals(productExpected, productActual);
    }
}
