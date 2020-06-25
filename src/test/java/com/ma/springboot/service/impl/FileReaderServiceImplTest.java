package com.ma.springboot.service.impl;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FileReaderServiceImplTest {
    FileReaderServiceImpl reader = new FileReaderServiceImpl();

    @Test
    void readAllLines_TRUE() {

        List<String> expected = reader.readAllLines("src/test/resources/ReadFile-test.txt");
        List<String> actual = List.of("test line");

        assertEquals(actual, expected);
    }
}