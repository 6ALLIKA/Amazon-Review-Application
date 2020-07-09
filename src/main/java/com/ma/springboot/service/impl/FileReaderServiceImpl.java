package com.ma.springboot.service.impl;

import com.ma.springboot.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import lombok.extern.log4j.Log4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public CSVParser readAllLines(String path) {
        String replacedPath = path.replaceAll("[/\\\\]+",
                Matcher.quoteReplacement(System.getProperty("file.separator")));
        CSVParser csvParser = null;
        try (InputStream inputStream = new FileInputStream(replacedPath);
                BufferedReader fileReader = new BufferedReader(
                        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return csvParser;
    }
}
