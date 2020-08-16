package com.bins.controller;

import com.bins.bean.PageInfo;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")        //加不加“/"都可以
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("login.do")
    //username，password需要和jsp文件内input标签内的name属性相同
    public ModelAndView login(String username,String password,HttpSession session){

        User user = userService.login(username,password);
        ModelAndView modelAndView = new ModelAndView();
        if(user!=null){
            session.setAttribute("user",user);
            modelAndView.setViewName("main");
        }else{
            modelAndView.setViewName("../failer");
        }
        return modelAndView;
    }

    @RequestMapping("findAll.do")
    public ModelAndView findAll(String username, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "0") int type,HttpSession session){
        if(type==1){    //搜索功能
            session.setAttribute("sn",username);
        }else if(type==2){//
            session.removeAttribute("sn");
        }
        else {
            username = (String)session.getAttribute("sn");
        }

        //方法名无所谓可以随便写
        PageInfo pageInfo = userService.findAll(username,currentPage);
        ModelAndView modelAndView = new ModelAndView();
        //将数据绑定到视图解析器
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");
        //modeAndView.addObject("sn",username);
        return modelAndView;
    }

    @RequestMapping("deleteById.do")
    public String delete(int id){
        userService.deleteById(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("deleteAll.do")
    @ResponseBody
    public String deleteAll(String userIdList){
        String[] userIds = userIdList.split(",");
        List<Integer> ids = new ArrayList<>();
        for(String tmp:userIds){
            ids.add(Integer.parseInt(tmp));
        }
        userService.deleteAll(ids);
        return "ok";
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

        List<Role> roles = roleService.findNoRoles(id);
        modelAndView.addObject("roles",roles);
        return modelAndView;
    }

    @RequestMapping("addRole.do")
    @ResponseBody           //保证返回的数据是json字符串
    public String addRole(String roleList,String userId){
//        roleService.addRoleToUser(userId,roleId);
        String[] roleIds = roleList.split(",");
        List<Integer> ids = new ArrayList<>();
        for(String tmp:roleIds){
            ids.add(Integer.parseInt(tmp));
        }
        roleService.addRoleToUser(ids,Integer.parseInt(userId));
        return "ok";
    }

}