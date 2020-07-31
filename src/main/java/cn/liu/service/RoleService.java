package cn.liu.service;

import cn.liu.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface RoleService {

    String loginCheck(Role role, String remember, HttpServletResponse response);

    Role queryCookie(HttpServletRequest request);
}
