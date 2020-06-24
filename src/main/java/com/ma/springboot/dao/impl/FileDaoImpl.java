package com.ma.springboot.dao.impl;

import com.ma.springboot.dao.FileDao;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;

@Log4j
@Repository
public class FileDaoImpl implements FileDao {

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
