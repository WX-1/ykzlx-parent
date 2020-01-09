package com.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.pojo.User;
import com.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Reference
    private UserService userService;


    @RequestMapping("/login")
    public String login(String username){
             User user = userService.selectUser(username);
             System.out.print(user.getStatus());
          if (user.getStatus()==1){
              return "redirect:html/list.html";
          }if (user.getStatus()==2){
              return "redirect:html/olist.html";
          }
          return null;
    }
}
