package com.ma.springboot.service;

import com.ma.springboot.model.dto.LineFromCsvDto;
import java.util.List;

public interface FileParserService {
    List<LineFromCsvDto> parseLines(List<String> fileLines);
}
