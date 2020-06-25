package com.ma.springboot.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class LineFromCsvDto {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private Integer helpfulnessNumerator;
    private Integer helpfulnessDenominator;
    private Integer score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
