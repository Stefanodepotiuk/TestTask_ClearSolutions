package com.example.testtask_clearsolutions.dao;

import com.example.testtask_clearsolutions.modela.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

}
