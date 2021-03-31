package com.daxian.controller;

import com.daxian.entry.Result;
import com.daxian.pojo.User;
import com.daxian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public Result findAll(){
        List<User> userList = userService.findAll();
        try {
            return new Result(true,"查询成功老二",userList);        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"查询失败了（制造冲突）");
        }
    }
    @RequestMapping("/add")
    public Result add(@RequestBody  User user){
        try {
            userService.add(user);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败 ");
        }
    }
}
