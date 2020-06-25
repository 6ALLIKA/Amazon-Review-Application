package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.dto.LineFromCsvDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class LineFromCsvMapperDto {

    public LineFromCsvDto parseLineToDto(String line) {
        LineFromCsvDto parsedLine = new LineFromCsvDto();
        String[] data = line.split(",");
        parsedLine.setId(Long.parseLong(data[0]));
        parsedLine.setProductId(data[1]);
        parsedLine.setUserId(data[2]);
        parsedLine.setProfileName(data[3]);
        parsedLine.setHelpfulnessNumerator(Integer.parseInt(data[4]));
        parsedLine.setHelpfulnessDenominator(Integer.parseInt(data[5]));
        parsedLine.setScore(Integer.parseInt(data[6]));
        parsedLine.setTime(convertToLocalDateTime(data[7]));
        parsedLine.setSummary(data[8]);
        parsedLine.setText(Stream.of(data).skip(9).collect(Collectors.joining(",")));
        return parsedLine;
    }

    private LocalDateTime convertToLocalDateTime(String millis) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(millis));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
