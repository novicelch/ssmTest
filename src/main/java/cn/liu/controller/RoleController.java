package cn.liu.controller;

import cn.liu.pojo.Role;
import cn.liu.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("rc")
public class RoleController {
    @Autowired
    RoleService service;
    @RequestMapping("firstShiro.do")
    public String firstShiro(){
        return "login";
    }
    @RequestMapping("checkLogin.ajax")
    @ResponseBody
    public String checkLogin(Role role, String remember, HttpServletResponse response){
        System.err.println(remember);
        String info = service.loginCheck(role,remember,response);
//        response.addCookie();
        return info;
    }
    @RequestMapping("success.do")
    public String success(){
        return "index";
    }
    @RequestMapping("showWelcome.do")
    public String showWelcome(){
        return "welcome";
    }
    @RequestMapping(value = "logout.ajax",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        Role r =service.queryCookie(request);
        subject.logout();
        return r;
    }
}