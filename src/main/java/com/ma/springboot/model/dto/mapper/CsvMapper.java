package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.dto.CsvReviewDto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

@Component
public class CsvMapper {
    private static final int REVIEW_ID = 0;
    private static final int PRODUCT_ID = 1;
    private static final int USER_ID = 2;
    private static final int PROFILE_NAME = 3;
    private static final int HELPFULNESS_NUMERATOR = 4;
    private static final int HELPFULNESS_DENOMINATOR = 5;
    private static final int REVIEW_SCORE = 6;
    private static final int REVIEW_TIME = 7;
    private static final int REVIEW_SUMMARY = 8;
    private static final int REVIEW_TEXT = 9;

    public CsvReviewDto parseLineToDto(CSVRecord csvRecord) {
        CsvReviewDto csvReviewDto = new CsvReviewDto(
                Long.parseLong(csvRecord.get("Id")),
                csvRecord.get("ProductId"),
                csvRecord.get("UserId"),
                csvRecord.get("ProfileName"),
                Integer.parseInt(csvRecord.get("HelpfulnessNumerator")),
                Integer.parseInt(csvRecord.get("HelpfulnessDenominator")),
                Integer.parseInt(csvRecord.get("Score")),
                convertToLocalDateTime(csvRecord.get("Time")),
                csvRecord.get("Summary"),
                csvRecord.get("Text")
        );
        return csvReviewDto;
    }

    private LocalDateTime convertToLocalDateTime(String millis) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(millis));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
