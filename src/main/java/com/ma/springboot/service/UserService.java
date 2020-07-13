package com.ma.springboot.service;

import com.ma.springboot.model.User;
import java.util.List;

public interface UserService extends EntityService<User> {
    List<User> getMostActiveUsers(int limit, int offset);
}
