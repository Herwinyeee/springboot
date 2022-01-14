package com.ye.service;

import com.ye.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> queryUserList();

    User queryUserById(int id);

    int deleteUserById(int id);

    int updateUser(User user);

    int addUser(User user);
}
