package cn.liu.service.impl;

import cn.liu.pojo.Role;
import cn.liu.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class RoleServiceImpl implements RoleService {

    public String loginCheck(Role role, String remember, HttpServletResponse response) {
        Subject s = SecurityUtils.getSubject();
        if(!s.isAuthenticated()){
//           UsernamePasswordToken(username,password)
            UsernamePasswordToken upt = new UsernamePasswordToken(role.getrName(),role.getrPassword());
            upt.setRememberMe(true);
            try{
                s.login(upt);
                s.getSession().setAttribute("userName",role.getrName());
                System.err.println(remember);
                Cookie c = new Cookie("UserName",role.getrName());
                Cookie c2 = new Cookie("PassWord",role.getrPassword());
                if(remember.equals("YES")){
                    c.setMaxAge(100);
                    c2.setMaxAge(100);
                }else{
                    c.setMaxAge(0);
                    c2.setMaxAge(0);
                }
                response.addCookie(c);
                response.addCookie(c2);
                return "success";
            }catch (AuthenticationException a){
                return "Error";
            }
        }
        return "Error";
    }

    public Role queryCookie(HttpServletRequest request) {
        Role r = new Role();
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies) {
            if(c.getName().equals("UserName")){
                r.setrName(c.getValue());
            }else if(c.getName().equals("PassWord")){
                r.setrPassword(c.getValue());
            }
        }
        return r;
    }
}
