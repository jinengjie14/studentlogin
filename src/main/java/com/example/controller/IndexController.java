package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Entity.User;
import com.example.dao.UserDao;

@Controller  
public class IndexController {  
  
    @Autowired  
    private UserDao userDao;  
  
    //index页面  
    @RequestMapping("/index")  
    public String index() {  
        return "index";  
    }  
  
    //登录页面  
    @RequestMapping("/register")  
    public String register(){  
        return "register";  
    }  
  
    @RequestMapping("/")  
    public String login(){  
        return "login";  
    }
    //注册方法  
    @RequestMapping("/addregister")  
    public String register(HttpServletRequest request){  
    	String name = request.getParameter("name");  
        String email = request.getParameter("email");  
        String password = request.getParameter("password");  
        String password2 = request.getParameter("password2");
        String phonenumber = request.getParameter("phonenumber");
        if (password.equals(password2)){  
            User user = new User();  
            user.setName(name);
            user.setEmail(email);  
            user.setPassword(password); 
            user.setPhonenumber(phonenumber);
            userDao.save(user);  
            return "login";  
        }else {  
            return "register";  
        }  
    }  
  
  //登录方法  
    @RequestMapping("/addlogin")  
    public String login(HttpServletRequest request){  
        String email = request.getParameter("email");  
        String password = request.getParameter("password");  
        User user = userDao.findByEmailAndPassword(email, password);  
        String str = "";  
        if (user !=null){  
            str = "index";  
        }else {  
            str = "login";  
        }  
        return str;  
    }  
    
}