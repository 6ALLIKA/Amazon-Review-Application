package com.ma.springboot.service;

import com.ma.springboot.model.dto.CsvReviewDto;
import java.util.List;
import org.apache.commons.csv.CSVParser;

public interface FileParserService {
    List<CsvReviewDto> parseLines(CSVParser csvParser);
}
