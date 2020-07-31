package cn.liu.dao;

import cn.liu.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Role selectByName(String username);
}