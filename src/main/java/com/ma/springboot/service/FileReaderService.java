package com.ma.springboot.service;

import org.apache.commons.csv.CSVRecord;

public interface FileReaderService {

    Iterable<CSVRecord> getRecordsFromCsv(String path);
}
