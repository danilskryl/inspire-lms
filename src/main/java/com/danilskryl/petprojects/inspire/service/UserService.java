package com.danilskryl.petprojects.inspire.service;

import com.danilskryl.petprojects.inspire.entity.User;
import com.danilskryl.petprojects.inspire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Transactional
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Transactional
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public User updateUser(User user) {
        return repository.save(user);
    }
}
