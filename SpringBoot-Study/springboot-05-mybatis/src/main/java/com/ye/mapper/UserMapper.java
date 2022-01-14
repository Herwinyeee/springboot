package com.ye.mapper;

import com.ye.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int deleteUserById(int id);

    int updateUser(User user);

    int addUser(User user);
}
