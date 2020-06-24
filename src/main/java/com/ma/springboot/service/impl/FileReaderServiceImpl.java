package com.ma.springboot.service.impl;

import com.ma.springboot.service.FileReaderService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class FileReaderServiceImpl implements FileReaderService {

    @SneakyThrows
    @Override
    public List<String> readAllLines(String path) {
        long start = System.currentTimeMillis();
        List<String> fileLines = Files.readAllLines(Paths.get(path));
        long end = System.currentTimeMillis();
        log.info(start - end);

        return fileLines;
    }
}
