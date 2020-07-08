package com.ma.springboot.model.dto.mapper;

import com.ma.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User getUserFromParsedLineDto(CsvReviewDto csvReviewDto) {
        User user = new User();
        user.setId(csvReviewDto.getUserId());
        user.setProfileName(csvReviewDto.getProfileName());
        return user;
    }
}