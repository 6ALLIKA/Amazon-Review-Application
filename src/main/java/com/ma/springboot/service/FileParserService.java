package com.ma.springboot.service;

import com.ma.springboot.model.dto.LineFromCSVDto;
import java.util.List;

public interface FileParserService {
    List<LineFromCSVDto> parseLines(List<String> fileLines);
}
