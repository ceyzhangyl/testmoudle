package com.example.demo5.service;

import com.example.demo5.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User inserByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
