package com.uni.onlineedu.userinfo.service;

import com.uni.onlineedu.userinfo.entity.User;
import com.uni.onlineedu.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long pk) {
        userRepository.deleteById(pk);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User getById(Long pk) {
        return userRepository.findById(pk).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
