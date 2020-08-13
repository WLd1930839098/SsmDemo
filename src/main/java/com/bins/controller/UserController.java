
package com.bins.controller;

import com.bins.bean.Role;
import com.bins.bean.User;
import com.bins.service.RoleService;
import com.bins.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")        //加不加“/"都可以
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping("login.do")
    //username，password需要和jsp文件内input标签内的name属性相同
    public ModelAndView login(String username,String password){

        boolean flag = userService.login(username,password);
        ModelAndView modelAndView = new ModelAndView();
        if(flag){
            modelAndView.setViewName("main");
        }else{
            modelAndView.setViewName("../failer");
        }
        return modelAndView;
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll(String username){
        //方法名无所谓可以随便写
        List<User> userList = userService.findAll(username);
        ModelAndView modelAndView = new ModelAndView();
        //将数据绑定到视图解析器
        modelAndView.addObject("users",userList);//在界面中就可以使用users来获得所有User对象
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("deleteById.do")
    public String delete(int id){
        userService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("deleteAll.do")
    public String deleteAll(){
        userService.deleteAll();
        return "redirect:findAll.do";
    }

    @RequestMapping("add.do")
    public String addUser(User user){
        userService.add(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("toUpdate.do")
    public ModelAndView toUpdate(int id){
        User user = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-update");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping("update.do")
    public String updateUser(User user){
        userService.updateById(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("toAddRole.do")
    public ModelAndView toAddRole(int id){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-role-add");
        modelAndView.addObject("id",id);

        List<Role> roles = roleService.findAll();
        modelAndView.addObject("roles",roles);
        return modelAndView;
    }

}