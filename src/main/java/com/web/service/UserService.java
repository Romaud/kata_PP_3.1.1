package com.web.service;

import com.web.dao.UserRepository;
import com.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> listUsers() {
        return repository.findAll();
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public User getUserById(Long id) {
        User user = null;
        Optional<User> optional = repository.findById(id);
        if (optional.isPresent()) {
            user = optional.get();
        }
        return user;
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
