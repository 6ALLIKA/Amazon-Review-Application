package com.ma.springboot.service.impl;

import com.ma.springboot.model.User;
import com.ma.springboot.repository.UserRepository;
import com.ma.springboot.service.UserService;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(Set<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getMostActiveUsers(int limit, int offset) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        return userRepository.findAll(pageRequest);
    }
}
