package com.capgemini.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.training.Entity.UserEntity;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}