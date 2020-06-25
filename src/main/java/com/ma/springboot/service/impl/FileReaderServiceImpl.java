package com.ma.springboot.service.impl;

import com.ma.springboot.service.FileReaderService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class FileReaderServiceImpl implements FileReaderService {

    @SneakyThrows
    @Override
    public List<String> readAllLines(String path) {
        String replaced = path.replaceAll("[/\\\\]+",
                Matcher.quoteReplacement(System.getProperty("file.separator")));

        return Files.readAllLines(Paths.get(replaced));
    }
}
