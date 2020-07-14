package com.ma.springboot.service.impl;

import com.ma.springboot.model.dto.CsvReviewDto;
import com.ma.springboot.model.dto.mapper.CsvMapper;
import com.ma.springboot.service.FileParserService;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileParserFromCsvServiceImpl implements FileParserService {
    private final CsvMapper mapperToDto;

    @Autowired
    public FileParserFromCsvServiceImpl(CsvMapper mapperToDto) {
        this.mapperToDto = mapperToDto;
    }

    @SneakyThrows
    @Override
    public List<CsvReviewDto> parseLines(Iterable<CSVRecord> csvRecords) {
        List<CsvReviewDto> csvReviewDtoList = new ArrayList<>();
        for (CSVRecord csvRecord : csvRecords) {
            csvReviewDtoList.add(mapperToDto.parseLineToDto(csvRecord));
        }

        return csvReviewDtoList;
    }
}
