package com.example.test05.controller;

import com.example.test05.mapper.UserMapper;
import com.example.test05.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class hiController {
    @Autowired
    private UserMapper usermapper;
    @GetMapping("/register")    //路径
    public String register()
    {
        return "register";
    }

    //添加用户，即用户注册
    @RequestMapping("/adduser")
    public String addser(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username!=null&&password!=null)
        {
            usermapper.adduser(username,password);  //有输出用户名和密码时才添加到数据库
        }
        return "register";
    }

    //删除用户，根据用户名删除
    @RequestMapping("/deluser")
    public String deluser(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        usermapper.deluser(username);
        return "register";
    }

    //修改用户密码
    @RequestMapping("/changepwd")
    public String changepwd(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        usermapper.changepwd(username,password);
        return "register";
    }

    //查询用户
    @RequestMapping("/searchuser")
    public String searchuser(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        User user=usermapper.searchuser(username);
        System.out.println(user);
        return "register";
    }

}
