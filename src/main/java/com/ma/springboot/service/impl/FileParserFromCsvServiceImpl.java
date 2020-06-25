package com.ma.springboot.service.impl;

import com.ma.springboot.model.dto.LineFromCsvDto;
import com.ma.springboot.model.dto.mapper.LineFromCsvMapperDto;
import com.ma.springboot.service.FileParserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileParserFromCsvServiceImpl implements FileParserService {
    private final LineFromCsvMapperDto mapperToDto;

    @Autowired
    public FileParserFromCsvServiceImpl(LineFromCsvMapperDto mapperToDto) {
        this.mapperToDto = mapperToDto;
    }

    @Override
    public List<LineFromCsvDto> parseLines(List<String> fileLines) {
        List<LineFromCsvDto> result = new ArrayList<>();
        fileLines.stream().skip(1).forEach(s -> {
            result.add(mapperToDto.parseLineToDto(s));
        });
        return result;
    }
}
