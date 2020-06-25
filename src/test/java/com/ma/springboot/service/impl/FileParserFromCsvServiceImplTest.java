package com.ma.springboot.service.impl;

import com.ma.springboot.model.dto.LineFromCsvDto;
import com.ma.springboot.model.dto.mapper.LineFromCsvMapperDto;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileParserFromCsvServiceImplTest {
    private FileParserFromCsvServiceImpl fileParserFromCsvService =
            new FileParserFromCsvServiceImpl(new LineFromCsvMapperDto());

    @Test
    void parsing_TRUE() {
        String empty = "";
        String s1 = "1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian,1,1,5,1303862400,Good Quality Dog Food,"
                + "I have bought several of the Vitality canned dog food products and have found them "
                + "all to be of good quality. The product looks more like a stew than a processed meat "
                + "and it smells better. My Labrador is finicky and she appreciates this product " +
                "better than  most.";
        String s2 = "2,B00813GRG4,A1D87F6ZCVE5NK,dll pa,0,0,1,1346976000,Not as Advertised,"
                + "\"Product arrived labeled as Jumbo Salted Peanuts...the peanuts were actually "
                + "small sized unsalted. Not sure if this was an error or if the vendor intended to "
                + "represent the product as \"\"Jumbo\"\".\"";
        String s3 = "3,B000LQOCH0,ABXLMWJIXXAIN,\"Natalia Corres \"\"Natalia Corres\"\"\",1,1,4,"
                + "1219017600,\"\"\"Delight\"\" says it all\",\"This is a "
                + "confection that has been around a few centuries.  It is a light, "
                + "pillowy citrus gelatin with nuts - in this case Filberts. And it is "
                + "cut into tiny squares and then liberally coated with powdered sugar.  "
                + "And it is a tiny mouthful of heaven.  Not too chewy, and very flavorful.  "
                + "I highly recommend this yummy treat.  If you are familiar with the story of "
                + "C.S. Lewis' \"\"The Lion, The Witch, and The Wardrobe\"\" - this is the treat "
                + "that seduces Edmund into selling out his Brother and Sisters to the Witch.\"";
        List<String> data = new ArrayList<>();
        data.add(empty);
        data.add(s1);
        data.add(s2);
        data.add(s3);

        LineFromCsvDto dto1 = new LineFromCsvDto();
        dto1.setId(1L);
        dto1.setProductId("B001E4KFG0");
        dto1.setUserId("A3SGXH7AUHU8GW");
        dto1.setProfileName("delmartian");
        dto1.setHelpfulnessNumerator(1);
        dto1.setHelpfulnessDenominator(1);
        dto1.setScore(5);
        dto1.setTime(Instant.ofEpochMilli(1303862400L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto1.setSummary("Good Quality Dog Food");
        dto1.setText("I have bought several of the Vitality canned dog food products and "
                + "have found them all to be of good quality. The product looks more like "
                + "a stew than a processed meat and it smells better. My Labrador is finicky"
                + " and she appreciates this product better than  most.");

        LineFromCsvDto dto2 = new LineFromCsvDto();
        dto2.setId(2L);
        dto2.setProductId("B00813GRG4");
        dto2.setUserId("A1D87F6ZCVE5NK");
        dto2.setProfileName("dll pa");
        dto2.setHelpfulnessNumerator(0);
        dto2.setHelpfulnessDenominator(0);
        dto2.setScore(1);
        dto2.setTime(Instant.ofEpochMilli(1346976000L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto2.setSummary("Not as Advertised");
        dto2.setText("\"Product arrived labeled as Jumbo Salted Peanuts...the peanuts were "
                + "actually small sized unsalted. Not sure if this was an error or "
                + "if the vendor intended to represent the product as \"\"Jumbo\"\".\"");

        LineFromCsvDto dto3 = new LineFromCsvDto();
        dto3.setId(3L);
        dto3.setProductId("B000LQOCH0");
        dto3.setUserId("ABXLMWJIXXAIN");
        dto3.setProfileName("\"Natalia Corres \"\"Natalia Corres\"\"\"");
        dto3.setHelpfulnessNumerator(1);
        dto3.setHelpfulnessDenominator(1);
        dto3.setScore(4);
        dto3.setTime(Instant.ofEpochMilli(1219017600L)
                .atZone(ZoneId.systemDefault()).toLocalDateTime());
        dto3.setSummary("\"\"\"Delight\"\" says it all\"");
        dto3.setText("\"This is a confection that has been around a few centuries. "
                + " It is a light, pillowy citrus gelatin with nuts - in this case Filberts. "
                + "And it is cut into tiny squares and then liberally coated with powdered sugar. "
                + " And it is a tiny mouthful of heaven.  Not too chewy, and very flavorful. "
                + " I highly recommend this yummy treat.  If you are familiar with the story of "
                + "C.S. Lewis' \"\"The Lion, The Witch, and The Wardrobe\"\" - this is the treat "
                + "that seduces Edmund into selling out his Brother and Sisters to the Witch.\"");

        List<LineFromCsvDto> expected = new ArrayList<>();
        expected.add(dto1);
        expected.add(dto2);
        expected.add(dto3);

        assertEquals(expected, fileParserFromCsvService.parseLines(data));
    }
}