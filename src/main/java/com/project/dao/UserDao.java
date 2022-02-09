package com.project.dao;

import com.project.model.User;

import java.io.Serializable;

public interface UserDao {
    User getIdByUsername(String username);
    User getById(Long id);
}
