package com.ye.controller;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @GetMapping("/add/{id}/{name}")
    public String addUser(@PathVariable("id") int id, @PathVariable("name") String name){
        String sql = "insert into user(id,name) values(?,?)";
        Object[] objects = new Object[2];
        objects[0] = id;
        objects[1] = name;
        jdbcTemplate.update(sql,objects);
        return "add-OK";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id){
        String sql = "update user set name=?  where id="+id;

        Object[] objects = new Object[1];
        objects[0] = "都是够女人";
        String name = "刘翔一";
        jdbcTemplate.update(sql,name);
        return "update-OK";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return "delete-OK";
    }


}
