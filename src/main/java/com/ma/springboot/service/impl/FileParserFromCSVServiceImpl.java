package com.ma.springboot.service.impl;

import com.ma.springboot.model.dto.LineFromCSVDto;
import com.ma.springboot.model.dto.mapper.LineFromCSVMapperDto;
import com.ma.springboot.service.FileParserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileParserFromCSVServiceImpl implements FileParserService {
    private final LineFromCSVMapperDto mapperToDto;

    @Autowired
    public FileParserFromCSVServiceImpl(LineFromCSVMapperDto mapperToDto) {
        this.mapperToDto = mapperToDto;
    }

    @Override
    public List<LineFromCSVDto> parseLines(List<String> fileLines) {
        List<LineFromCSVDto> result = new ArrayList<>();
        fileLines.stream().skip(1).forEach(s -> {
            result.add(mapperToDto.parseLineToDto(s));
        });
        return result;
    }
}
