package com.example.demo.service;

import com.example.demo.dao.TUser;

import java.util.List;

public interface UserService {

    void save(String name);

    List<TUser> list();
}
