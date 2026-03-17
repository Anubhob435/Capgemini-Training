package com.capgemini.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.Entity.UserEntity;
import com.capgemini.training.repository.LoginRepository;

@Service
public class LoginServices {

    @Autowired
    LoginRepository loginRepository;

    public UserEntity registerUser(UserEntity userEntity) {
        return loginRepository.save(userEntity);
    }

    public UserEntity authenticateUser(String username, String password) {
        UserEntity user = loginRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<UserEntity> getAllUsers() {
        return loginRepository.findAll();
    }

    public UserEntity getUserById(Integer id) {
        Optional<UserEntity> user = loginRepository.findById(id);
        return user.orElse(null);
    }

    public void deleteUser(Integer id) {
        loginRepository.deleteById(id);
    }

}
