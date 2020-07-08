package com.ma.springboot.service;

import org.apache.commons.csv.CSVParser;

public interface FileReaderService {

    CSVParser readAllLines(String path);
}
